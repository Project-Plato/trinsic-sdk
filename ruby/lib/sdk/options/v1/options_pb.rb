# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: sdk/options/v1/options.proto

require 'google/protobuf'

require 'services/account/v1/account_pb'
Google::Protobuf::DescriptorPool.generated_pool.build do
  add_file("sdk/options/v1/options.proto", :syntax => :proto3) do
    add_message "sdk.options.v1.ServiceOptions" do
      optional :server, :message, 1, "sdk.options.v1.ServerConfiguration"
      optional :profile, :message, 2, "services.account.v1.AccountProfile"
      optional :ecosystem, :string, 3
    end
    add_message "sdk.options.v1.ServerConfiguration" do
      optional :endpoint, :string, 1
      optional :port, :int32, 2
      optional :use_tls, :bool, 3
    end
  end
end

module Sdk
  module Options
    module V1
      ServiceOptions = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("sdk.options.v1.ServiceOptions").msgclass
      ServerConfiguration = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("sdk.options.v1.ServerConfiguration").msgclass
    end
  end
end