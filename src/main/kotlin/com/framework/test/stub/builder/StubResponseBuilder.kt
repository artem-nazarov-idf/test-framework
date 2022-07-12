package com.framework.test.stub.builder

import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock

class StubResponseBuilder(
  private val responseDefinitionBuilder: ResponseDefinitionBuilder = WireMock.aResponse()
) {

  fun build(): ResponseDefinitionBuilder {
    return responseDefinitionBuilder
  }

  fun addParametersToResponse(mockData: MockData): StubResponseBuilder {
    return this
      .addStatus(mockData.responseStatusCode)
      .addHeaders(mockData.responseHeaders)
      .addBodyFromFile(mockData.filePath)
  }

  private fun addStatus(status: Int) = apply { responseDefinitionBuilder.withStatus(status) }
  private fun addHeaders(headers: Map<String, String>?) = apply {
    headers?.forEach { (key, value) -> responseDefinitionBuilder.withHeader(key, value) }
  }
  private fun addBodyFromFile(filePath: String) = apply { responseDefinitionBuilder.withBodyFile(filePath) }
}