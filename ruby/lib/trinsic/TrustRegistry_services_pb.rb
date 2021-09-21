# Generated by the protocol buffer compiler.  DO NOT EDIT!
# Source: TrustRegistry.proto for package 'trinsic.services'

require 'grpc'
require 'TrustRegistry_pb'

module Trinsic
  module Services
    module TrustRegistry
      class Service

        include ::GRPC::GenericService

        self.marshal_class_method = :encode
        self.unmarshal_class_method = :decode
        self.service_name = 'trinsic.services.TrustRegistry'

        # Adds a trust registry defintion to the ecosystem
        rpc :AddFramework, ::Trinsic::Services::AddFrameworkRequest, ::Trinsic::Services::AddFrameworkResponse
        rpc :RemoveFramework, ::Trinsic::Services::RemoveFrameworkRequest, ::Trinsic::Services::RemoveFrameworkResponse
        rpc :SearchRegistry, ::Trinsic::Services::SearchRegistryRequest, ::Trinsic::Services::SearchRegistryResponse
        # Registers an authoritative issuer with a credential template
        rpc :RegisterIssuer, ::Trinsic::Services::RegisterIssuerRequest, ::Trinsic::Services::RegisterIssuerResponse
        rpc :RegisterVerifier, ::Trinsic::Services::RegisterVerifierRequest, ::Trinsic::Services::RegisterVerifierResponse
        # Removes an authoritative issuer with a credential template from the trust registry
        rpc :UnregisterMember, ::Trinsic::Services::UnregisterMemberRequest, ::Trinsic::Services::UnregisterMemberResponse
        rpc :CheckIssuerStatus, ::Trinsic::Services::CheckIssuerStatusRequest, ::Trinsic::Services::CheckIssuerStatusResponse
        rpc :CheckVerifierStatus, ::Trinsic::Services::CheckVerifierStatusRequest, ::Trinsic::Services::CheckVerifierStatusResponse
        rpc :FetchData, ::Trinsic::Services::FetchDataRequest, stream(::Trinsic::Services::FetchDataResponse)
      end

      Stub = Service.rpc_stub_class
    end
  end
end