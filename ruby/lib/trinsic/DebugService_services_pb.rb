# Generated by the protocol buffer compiler.  DO NOT EDIT!
# Source: DebugService.proto for package 'trinsic.services'

require 'grpc'
require 'DebugService_pb'

module Trinsic
  module Services
    module Debugging
      class Service

        include ::GRPC::GenericService

        self.marshal_class_method = :encode
        self.unmarshal_class_method = :decode
        self.service_name = 'trinsic.services.Debugging'

        rpc :CallEmpty, ::Google::Protobuf::Empty, ::Google::Protobuf::Empty
        rpc :CallEmptyAuth, ::Google::Protobuf::Empty, ::Google::Protobuf::Empty
      end

      Stub = Service.rpc_stub_class
    end
  end
end