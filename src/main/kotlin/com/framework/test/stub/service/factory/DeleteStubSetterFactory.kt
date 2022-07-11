package com.framework.test.stub.service.factory

import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.client.WireMock

class DeleteStubSetterFactory(private val actualWireMock: WireMock) : StubSetter {
  override fun addStub(stubDataClass: MockData) {
    with(stubDataClass) {
      actualWireMock.register(
        WireMock.delete(WireMock.urlPathMatching(endpoint))
          .willReturn(
            WireMock.aResponse()
              .withStatus(responseStatusCode)
              .withHeader("Content-Type", responseContentType)
              .withBodyFile(filePath)
          )
      )
    }
  }
}