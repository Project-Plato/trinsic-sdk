import ServiceBase from "./ServiceBase";
import {
    AccountClient,
    AccountProfile,
    ConfirmationMethod,
    InfoRequest,
    InfoResponse,
    SignInRequest,
    TokenProtection,
    ServiceOptions,
    ListDevicesRequest,
    ListDevicesResponse,
    RevokeDeviceRequest,
    RevokeDeviceResponse,
    ResponseStatus,
} from "./proto";
import {BlindOberonTokenRequest, Oberon, UnBlindOberonTokenRequest} from "@trinsic/okapi";

export class AccountService extends ServiceBase {
    client: AccountClient;

    constructor(options?: ServiceOptions) {
        super(options);

        this.client = new AccountClient(this.address, this.channelCredentials);
    }

    public signIn(request: SignInRequest): Promise<string> {
        request.setEcosystemId(request.getEcosystemId() || this.options.getDefaultEcosystem());

        return new Promise((resolve, reject) => {
            this.client.signIn(request, (error, response) => {
                if (error || response.getStatus() != ResponseStatus.SUCCESS) {
                    reject(error);
                } else {
                    const authToken = Buffer
                        .from(response.getProfile()!.serializeBinary())
                        .toString('base64url');

                    // set the auth token as active for the current service instance
                    this.options.setAuthToken(authToken);

                    resolve(authToken);
                }
            });
        });
    }

    public info(): Promise<InfoResponse> {
        const request = new InfoRequest();

        return new Promise(async (resolve, reject) => {
            try {
                let metadata = await this.getMetadata(request)
                this.client.info(request, metadata, (error, response) => {
                    if (error) {
                        reject(error);
                    } else {
                        resolve(response);
                    }
                });
            } catch (e) {
                reject(e);
            }
        });
    }

    /**
     * protect the given profile
     * @param profile The profile to protect with oberon blinding
     * @param securityCode must be utf-8 encoded `UInt8Array`. `string` will be decoded to utf-8.
     */
    public static async protect(profile: string | AccountProfile, securityCode: string | Uint8Array): Promise<string> {
        securityCode = AccountService.convertToUtf8(securityCode);
        profile = AccountService.convertToProfile(profile);
        let cloned = profile.clone();
        const request = new BlindOberonTokenRequest().setToken(cloned.getAuthToken()).setBlindingList([securityCode]);
        const result = await Oberon.blindToken(request);
        cloned = cloned.setAuthToken(result.getToken()).setProtection(new TokenProtection().setEnabled(true).setMethod(ConfirmationMethod.OTHER));
        return Buffer.from(cloned.serializeBinary()).toString('base64url');
    }

    /**
     * unprotect the given profile
     * @param profile The profile to unprotect with oberon blinding
     * @param securityCode must be utf-8 encoded `UInt8Array`. `string` will be decoded to utf-8.
     */
    public static async unprotect(profile: string | AccountProfile, securityCode: string | Uint8Array): Promise<string> {
        securityCode = AccountService.convertToUtf8(securityCode);
        profile = AccountService.convertToProfile(profile);
        let cloned = profile.clone();
        const request = new UnBlindOberonTokenRequest().setToken(cloned.getAuthToken()).setBlindingList([securityCode]);
        const result = await Oberon.unblindToken(request);
        cloned = cloned.setAuthToken(result.getToken()).setProtection(new TokenProtection().setEnabled(false).setMethod(ConfirmationMethod.NONE));
        return Buffer.from(cloned.serializeBinary()).toString('base64url');
    }

    private static convertToProfile(profile: string | AccountProfile): AccountProfile {
        if (typeof profile == 'string') {
            return AccountProfile.deserializeBinary(Buffer.from(profile, 'base64url'));
        }
        return profile;
    }

    private static convertToUtf8(securityCode: string | Uint8Array): Uint8Array {
        if (typeof securityCode == 'string') {
            return new TextEncoder().encode(securityCode);
        } else {
            return securityCode;
        }
    }

    public listDevices(request: ListDevicesRequest): Promise<ListDevicesResponse> {
        return new Promise(async (resolve, reject) => {
            this.client.listDevices(request, await this.getMetadata(request), (error, response) => {
                if (error) {
                    reject(error);
                } else {
                    resolve(response);
                }
            })
        })
    }

    public revokeDevice(request: RevokeDeviceRequest): Promise<RevokeDeviceResponse> {
        return new Promise(async (resolve, reject) => {
            this.client.revokeDevice(request, await this.getMetadata(request), (error, response) => {
                if (error) {
                    reject(error);
                } else {
                    resolve(response);
                }
            })
        })
    }
}
