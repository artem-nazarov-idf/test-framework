package com.framework.test.stub.service.factory

import com.framework.test.constants.RequestMethods
import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo

class StubSetterFactory(private val stubDataClass: MockData, wireMockServer: WireMockServer) {
  private val actualWireMock: WireMock = WireMockRuntimeInfo(wireMockServer).wireMock

  fun setStub() {
    return when (stubDataClass.method) {
      RequestMethods.POST -> PostStubSetterFactory(actualWireMock).addStub(stubDataClass)
      RequestMethods.GET -> GetStubSetterFactory(actualWireMock).addStub(stubDataClass)
      RequestMethods.DELETE -> DeleteStubSetterFactory(actualWireMock).addStub(stubDataClass)
    }
  }
}