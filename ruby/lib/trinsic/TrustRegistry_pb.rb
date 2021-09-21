# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: TrustRegistry.proto

require 'google/protobuf'

require 'CoreService_pb'
Google::Protobuf::DescriptorPool.generated_pool.build do
  add_file("TrustRegistry.proto", :syntax => :proto3) do
    add_message "trinsic.services.AddFrameworkRequest" do
      optional :governance_framework, :message, 1, "trinsic.services.GovernanceFramework"
    end
    add_message "trinsic.services.AddFrameworkResponse" do
      optional :status, :enum, 1, "trinsic.services.ResponseStatus"
    end
    add_message "trinsic.services.RemoveFrameworkRequest" do
      optional :governance_framework, :message, 1, "trinsic.services.GovernanceFramework"
    end
    add_message "trinsic.services.RemoveFrameworkResponse" do
      optional :status, :enum, 1, "trinsic.services.ResponseStatus"
    end
    add_message "trinsic.services.SearchRegistryRequest" do
      optional :query, :string, 1
      optional :continuation_token, :string, 2
      optional :options, :message, 5, "trinsic.services.RequestOptions"
    end
    add_message "trinsic.services.SearchRegistryResponse" do
      repeated :items, :message, 1, "trinsic.services.JsonPayload"
      optional :has_more, :bool, 2
      optional :count, :int32, 3
      optional :continuation_token, :string, 4
    end
    add_message "trinsic.services.GovernanceFramework" do
      optional :governance_framework_uri, :string, 1
      optional :trust_registry_uri, :string, 2
      optional :description, :string, 3
    end
    add_message "trinsic.services.RegisterIssuerRequest" do
      optional :credential_type_uri, :string, 10
      optional :valid_from_utc, :uint64, 11
      optional :valid_until_utc, :uint64, 12
      optional :governance_framework_uri, :string, 20
      optional :options, :message, 100, "trinsic.services.RequestOptions"
      oneof :authority do
        optional :did_uri, :string, 1
        optional :x509_cert, :string, 2
      end
    end
    add_message "trinsic.services.RegisterIssuerResponse" do
      optional :status, :enum, 1, "trinsic.services.ResponseStatus"
      optional :response_data, :message, 2, "trinsic.services.JsonPayload"
    end
    add_message "trinsic.services.RegisterVerifierRequest" do
      optional :presentation_type_uri, :string, 10
      optional :valid_from_utc, :uint64, 11
      optional :valid_until_utc, :uint64, 12
      optional :governance_framework_uri, :string, 20
      optional :options, :message, 100, "trinsic.services.RequestOptions"
      oneof :authority do
        optional :did_uri, :string, 1
        optional :x509_cert, :string, 2
      end
    end
    add_message "trinsic.services.RegisterVerifierResponse" do
      optional :status, :enum, 1, "trinsic.services.ResponseStatus"
      optional :response_data, :message, 2, "trinsic.services.JsonPayload"
    end
    add_message "trinsic.services.UnregisterMemberRequest" do
      oneof :member do
        optional :did_uri, :string, 1
        optional :x509_cert, :string, 2
      end
      oneof :template do
        optional :template_uri, :string, 10
        optional :context_uri, :string, 11
      end
    end
    add_message "trinsic.services.UnregisterMemberResponse" do
      optional :status, :enum, 1, "trinsic.services.ResponseStatus"
    end
    add_message "trinsic.services.CheckIssuerStatusRequest" do
      optional :governance_framework_uri, :string, 1
      optional :credential_type_uri, :string, 4
      oneof :member do
        optional :did_uri, :string, 2
        optional :x509_cert, :string, 3
      end
    end
    add_message "trinsic.services.CheckIssuerStatusResponse" do
      optional :governance_framework_uri, :string, 1
      optional :status, :enum, 4, "trinsic.services.RegistrationStatus"
    end
    add_message "trinsic.services.CheckVerifierStatusRequest" do
      optional :governance_framework_uri, :string, 1
      optional :presentation_type_uri, :string, 4
      oneof :member do
        optional :did_uri, :string, 2
        optional :x509_cert, :string, 3
      end
    end
    add_message "trinsic.services.CheckVerifierStatusResponse" do
      optional :governance_framework_uri, :string, 1
      optional :status, :enum, 4, "trinsic.services.RegistrationStatus"
    end
    add_message "trinsic.services.FetchDataRequest" do
      optional :governance_framework_uri, :string, 1
      optional :query, :string, 2
    end
    add_message "trinsic.services.FetchDataResponse" do
      optional :response, :message, 1, "trinsic.services.JsonPayload"
    end
    add_enum "trinsic.services.RegistrationStatus" do
      value :CURRENT, 0
      value :EXPIRED, 1
      value :TERMINATED, 2
      value :REVOKED, 3
      value :NOT_FOUND, 10
    end
  end
end

module Trinsic
  module Services
    AddFrameworkRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.AddFrameworkRequest").msgclass
    AddFrameworkResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.AddFrameworkResponse").msgclass
    RemoveFrameworkRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RemoveFrameworkRequest").msgclass
    RemoveFrameworkResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RemoveFrameworkResponse").msgclass
    SearchRegistryRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.SearchRegistryRequest").msgclass
    SearchRegistryResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.SearchRegistryResponse").msgclass
    GovernanceFramework = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.GovernanceFramework").msgclass
    RegisterIssuerRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RegisterIssuerRequest").msgclass
    RegisterIssuerResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RegisterIssuerResponse").msgclass
    RegisterVerifierRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RegisterVerifierRequest").msgclass
    RegisterVerifierResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RegisterVerifierResponse").msgclass
    UnregisterMemberRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.UnregisterMemberRequest").msgclass
    UnregisterMemberResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.UnregisterMemberResponse").msgclass
    CheckIssuerStatusRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.CheckIssuerStatusRequest").msgclass
    CheckIssuerStatusResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.CheckIssuerStatusResponse").msgclass
    CheckVerifierStatusRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.CheckVerifierStatusRequest").msgclass
    CheckVerifierStatusResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.CheckVerifierStatusResponse").msgclass
    FetchDataRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.FetchDataRequest").msgclass
    FetchDataResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.FetchDataResponse").msgclass
    RegistrationStatus = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("trinsic.services.RegistrationStatus").enummodule
  end
end