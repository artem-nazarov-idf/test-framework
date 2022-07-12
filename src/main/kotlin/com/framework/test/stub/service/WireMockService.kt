package com.framework.test.stub.service

import com.framework.test.constants.RequestMethods
import com.framework.test.http.client.CustomHttpClient
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.stub.builder.StubResponseBuilder
import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo

class WireMockService(
  private val applicationConfig: ApplicationConfig,
  wireMockServer: WireMockServer
) :
  StubOperation {
  private val actualWireMock: WireMock = WireMockRuntimeInfo(wireMockServer).wireMock
  private val stubUrl = "http://${applicationConfig.stub.host}:${applicationConfig.stub.port}"

  override fun addStub(stubDataClass: MockData) {
    stubDataClass.id = with(stubDataClass) {
      actualWireMock.register(
        when (stubDataClass.method) {
          RequestMethods.POST -> WireMock.post(WireMock.urlPathMatching(endpoint))
          RequestMethods.GET -> WireMock.get(WireMock.urlPathMatching(endpoint))
          RequestMethods.DELETE -> WireMock.delete(WireMock.urlPathMatching(endpoint))
        }
          .atPriority(stubDataClass.priority)
          .willReturn(
            StubResponseBuilder()
              .addParametersToResponse(stubDataClass).build()
          )
      ).id
    }
  }

  override fun deleteStub(stubDataClass: MockData) {
    CustomHttpClient(applicationConfig, stubUrl).delete("/__admin/mappings/${stubDataClass.id}")
  }

  override fun verifyStub(stubDataClass: MockData) {
    CustomHttpClient(applicationConfig, stubUrl).get("/__admin/mappings/${stubDataClass.id}")
  }
}