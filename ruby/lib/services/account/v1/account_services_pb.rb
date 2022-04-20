# Generated by the protocol buffer compiler.  DO NOT EDIT!
# Source: services/account/v1/account.proto for package 'services.account.v1'

require 'grpc'
require 'services/account/v1/account_pb'

module Services
  module Account
    module V1
      module Account
        class Service

          include ::GRPC::GenericService

          self.marshal_class_method = :encode
          self.unmarshal_class_method = :decode
          self.service_name = 'services.account.v1.Account'

          # Sign in to an already existing account
          rpc :SignIn, ::Services::Account::V1::SignInRequest, ::Services::Account::V1::SignInResponse
          # rpc SIgnInConfirm       (SignInConfirmRequest)      returns (SignInConfirmResponse);
          # Get account information
          rpc :Info, ::Services::Account::V1::InfoRequest, ::Services::Account::V1::InfoResponse
          # List all connected devices
          rpc :ListDevices, ::Services::Account::V1::ListDevicesRequest, ::Services::Account::V1::ListDevicesResponse
          # Revoke device access to the account's cloud wallet
          rpc :RevokeDevice, ::Services::Account::V1::RevokeDeviceRequest, ::Services::Account::V1::RevokeDeviceResponse
        end

        Stub = Service.rpc_stub_class
      end
    end
  end
end