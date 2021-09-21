# Generated by the protocol buffer compiler.  DO NOT EDIT!
# Source: IssuerService.proto for package 'trinsic.services'

require 'grpc'
require_relative 'IssuerService_pb'

module Trinsic
  module Services
    module Credential
      class Service

        include ::GRPC::GenericService

        self.marshal_class_method = :encode
        self.unmarshal_class_method = :decode
        self.service_name = 'trinsic.services.Credential'

        rpc :Issue, ::Trinsic::Services::IssueRequest, ::Trinsic::Services::IssueResponse
        rpc :CreateProof, ::Trinsic::Services::CreateProofRequest, ::Trinsic::Services::CreateProofResponse
        rpc :VerifyProof, ::Trinsic::Services::VerifyProofRequest, ::Trinsic::Services::VerifyProofResponse
        rpc :Send, ::Trinsic::Services::SendRequest, ::Trinsic::Services::SendResponse
      end

      Stub = Service.rpc_stub_class
    end
  end
end