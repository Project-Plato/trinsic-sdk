package trinsic.services.verifiablecredentials.v1

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import trinsic.services.verifiablecredentials.v1.VerifiableCredentialGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * services.verifiablecredentials.v1.VerifiableCredential.
 */
object VerifiableCredentialGrpcKt {
  const val SERVICE_NAME: String = VerifiableCredentialGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = VerifiableCredentialGrpc.getServiceDescriptor()

  val issueMethod: MethodDescriptor<VerifiableCredentials.IssueRequest,
      VerifiableCredentials.IssueResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getIssueMethod()

  val issueFromTemplateMethod: MethodDescriptor<VerifiableCredentials.IssueFromTemplateRequest,
      VerifiableCredentials.IssueFromTemplateResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getIssueFromTemplateMethod()

  val checkStatusMethod: MethodDescriptor<VerifiableCredentials.CheckStatusRequest,
      VerifiableCredentials.CheckStatusResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getCheckStatusMethod()

  val updateStatusMethod: MethodDescriptor<VerifiableCredentials.UpdateStatusRequest,
      VerifiableCredentials.UpdateStatusResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getUpdateStatusMethod()

  val createProofMethod: MethodDescriptor<VerifiableCredentials.CreateProofRequest,
      VerifiableCredentials.CreateProofResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getCreateProofMethod()

  val verifyProofMethod: MethodDescriptor<VerifiableCredentials.VerifyProofRequest,
      VerifiableCredentials.VerifyProofResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getVerifyProofMethod()

  val sendMethod: MethodDescriptor<VerifiableCredentials.SendRequest,
      VerifiableCredentials.SendResponse>
    @JvmStatic
    get() = VerifiableCredentialGrpc.getSendMethod()

  /**
   * A stub for issuing RPCs to a(n) services.verifiablecredentials.v1.VerifiableCredential service
   * as suspending coroutines.
   */
  @StubFor(VerifiableCredentialGrpc::class)
  class VerifiableCredentialCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<VerifiableCredentialCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions):
        VerifiableCredentialCoroutineStub = VerifiableCredentialCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun issue(request: VerifiableCredentials.IssueRequest, headers: Metadata = Metadata()):
        VerifiableCredentials.IssueResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getIssueMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun issueFromTemplate(request: VerifiableCredentials.IssueFromTemplateRequest,
        headers: Metadata = Metadata()): VerifiableCredentials.IssueFromTemplateResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getIssueFromTemplateMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun checkStatus(request: VerifiableCredentials.CheckStatusRequest, headers: Metadata =
        Metadata()): VerifiableCredentials.CheckStatusResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getCheckStatusMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun updateStatus(request: VerifiableCredentials.UpdateStatusRequest, headers: Metadata =
        Metadata()): VerifiableCredentials.UpdateStatusResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getUpdateStatusMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun createProof(request: VerifiableCredentials.CreateProofRequest, headers: Metadata =
        Metadata()): VerifiableCredentials.CreateProofResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getCreateProofMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun verifyProof(request: VerifiableCredentials.VerifyProofRequest, headers: Metadata =
        Metadata()): VerifiableCredentials.VerifyProofResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getVerifyProofMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun send(request: VerifiableCredentials.SendRequest, headers: Metadata = Metadata()):
        VerifiableCredentials.SendResponse = unaryRpc(
      channel,
      VerifiableCredentialGrpc.getSendMethod(),
      request,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the services.verifiablecredentials.v1.VerifiableCredential service
   * based on Kotlin coroutines.
   */
  abstract class VerifiableCredentialCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.Issue.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun issue(request: VerifiableCredentials.IssueRequest):
        VerifiableCredentials.IssueResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.Issue is unimplemented"))

    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.IssueFromTemplate.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun issueFromTemplate(request: VerifiableCredentials.IssueFromTemplateRequest):
        VerifiableCredentials.IssueFromTemplateResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.IssueFromTemplate is unimplemented"))

    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.CheckStatus.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun checkStatus(request: VerifiableCredentials.CheckStatusRequest):
        VerifiableCredentials.CheckStatusResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.CheckStatus is unimplemented"))

    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.UpdateStatus.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun updateStatus(request: VerifiableCredentials.UpdateStatusRequest):
        VerifiableCredentials.UpdateStatusResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.UpdateStatus is unimplemented"))

    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.CreateProof.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun createProof(request: VerifiableCredentials.CreateProofRequest):
        VerifiableCredentials.CreateProofResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.CreateProof is unimplemented"))

    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.VerifyProof.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun verifyProof(request: VerifiableCredentials.VerifyProofRequest):
        VerifiableCredentials.VerifyProofResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.VerifyProof is unimplemented"))

    /**
     * Returns the response to an RPC for
     * services.verifiablecredentials.v1.VerifiableCredential.Send.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun send(request: VerifiableCredentials.SendRequest):
        VerifiableCredentials.SendResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method services.verifiablecredentials.v1.VerifiableCredential.Send is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getIssueMethod(),
      implementation = ::issue
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getIssueFromTemplateMethod(),
      implementation = ::issueFromTemplate
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getCheckStatusMethod(),
      implementation = ::checkStatus
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getUpdateStatusMethod(),
      implementation = ::updateStatus
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getCreateProofMethod(),
      implementation = ::createProof
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getVerifyProofMethod(),
      implementation = ::verifyProof
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = VerifiableCredentialGrpc.getSendMethod(),
      implementation = ::send
    )).build()
  }
}
