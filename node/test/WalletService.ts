import test from "ava";
import {
  AccountService,
  CreateCredentialTemplateRequest,
  CredentialService, FieldType, IssueFromTemplateRequest,
  TemplateField,
  TemplateService,
  WalletService
} from "../src";
import {getTestServerConfig, getVaccineCertFrameJSON, getVaccineCertUnsignedJSON} from "./TestData";
import {AccountProfile} from "../lib";


require("dotenv").config();

const config = getTestServerConfig()

let profile = new AccountProfile();

test.before(async () => {
  let service = new AccountService({ server: config });
  let response = await service.signIn();

  profile = response.getProfile()!;
});

test("get account info", async (t) => {
  let service = new AccountService({ profile, server: config });
  let info = await service.info();

  t.not(info, null);
});

test("create new account", async (t) => {
  let service = new AccountService({ server: config });
  let response = await service.signIn();

  service.updateActiveProfile(response.getProfile()!);

  t.not(profile, null);
  t.pass();
});

test("Demo: create wallet, set profile, search records, issue credential", async (t) => {
  let credentialService = new CredentialService({ profile, server: config });
  let walletService = new WalletService({ profile, server: config });

  let issueResponse = await credentialService.issueCredential(getVaccineCertUnsignedJSON());

  let itemId = await walletService.insertItem(issueResponse);

  t.not(itemId, null);
  t.not(itemId, "");

  let items = await walletService.search();

  t.not(items, null);
  t.true(items.getItemsList().length > 0);

  let proof = await credentialService.createProof(itemId, getVaccineCertFrameJSON());

  let valid = await credentialService.verifyProof(proof);

  t.true(valid);
  t.pass();
});

test("Demo: template management and credential issuance from template", async (t) => {
  let credentialService = new CredentialService({ profile, server: config });
  let templateService = new TemplateService({ profile, server: config });

  // create example template
  let templateRequest = new CreateCredentialTemplateRequest().setName("My Example Credential").setAllowAdditionalFields(false);
  templateRequest.getFieldsMap().set("firstName", new TemplateField().setDescription("Given name"));
  templateRequest.getFieldsMap().set("lastName", new TemplateField());
  templateRequest.getFieldsMap().set("age", new TemplateField().setType(FieldType.NUMBER).setOptional(true));

  let template = await templateService.createCredentialTemplate(templateRequest);

  t.not(template, null);
  t.not(template.getData(), null);
  t.not(template.getData()!.getId(), null);
  t.not(template.getData()!.getSchemaUri(), null);

  // issue credential from this template
  let values = JSON.stringify({
    firstName: "Jane",
    lastName: "Doe",
    age: 42
  });

  let jsonDocument = await credentialService.issueFromTemplate(new IssueFromTemplateRequest().setTemplateId(template.getData()!.getId()).setValuesJson(values));

  t.not(jsonDocument, null);
  t.true(jsonDocument.hasOwnProperty("id"));
  t.true(jsonDocument.hasOwnProperty("credentialSubject"));

  t.pass();
});

// test("create wallet with provider invitation", async (t) => {
//   let providerService = new ProviderService(profile, config);
//   let walletService = new WalletService(profile, config);

//   // Provider creates initial wallet for Alice
//   let providerProfile = await walletService.createWallet();
//   providerService.updateActiveProfile(providerProfile);

//   let email = randomEmail();
//   let inviteRequest = new InviteRequest().setDescription("Test Wallet").setEmail(email);
//   let invitationResponse = await providerService.inviteParticipant(inviteRequest);

//   // Alice accepts the invitation and creates the wallet
//   let createResponse = await walletService.createWallet(invitationResponse.getInvitationId());
//   walletService.updateActiveProfile(createResponse);

//   // Alice searches for wallet records
//   let search = await walletService.search();
//   t.not(search, null);
//   t.true(search.getItemsList().length === 0);

//   // Send the document to an existing email
//   await walletService.send({ test: "value" }, email);

//   t.pass();
// });

// test("send an item to a user's wallet using email", async (t) => {
//   let providerService = new ProviderService(config);
//   let walletService = new WalletService(config);

//   let providerProfile = await walletService.createWallet();
//   providerService.updateActiveProfile(providerProfile);

//   // Provider creates initial wallet for Alice
//   let aliceEmail = randomEmail();
//   let aliceInviteRequest = new InviteRequest().setDescription("Test Wallet").setEmail(aliceEmail);
//   let invitationResponse = await providerService.inviteParticipant(aliceInviteRequest);
//   let aliceProfile = await walletService.createWallet(invitationResponse.getInvitationId());

//   let bobEmail = randomEmail();
//   let bobInviteRequest = new InviteRequest().setDescription("Test Wallet").setEmail(bobEmail);
//   invitationResponse = await providerService.inviteParticipant(bobInviteRequest);
//   let bobProfile = await walletService.createWallet(invitationResponse.getInvitationId());

//   // Alice's searches for wallet records
//   walletService.updateActiveProfile(aliceProfile);
//   await walletService.send({ test: "value" }, bobEmail);

//   walletService.updateActiveProfile(bobProfile);
//   let results = await walletService.search("SELECT * from c WHERE c.test = 'value' AND c._new = true");

//   t.not(results.getItemsList(), null);
//   t.true(results.getItemsList().length > 0);
//   t.pass();
// });
