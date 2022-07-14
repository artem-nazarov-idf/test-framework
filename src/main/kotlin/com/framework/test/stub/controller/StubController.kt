package com.framework.test.stub.controller

import com.framework.test.stub.config.MockData
import com.framework.test.stub.service.WireMockService
import com.github.tomakehurst.wiremock.client.WireMock

class StubController(
  wireMockClient: WireMock
) {
  private val mockService = WireMockService(wireMockClient)

  fun addStub(stubDataClass: MockData) {
    mockService.addStub(stubDataClass)
  }

  fun deleteStub(stubDataClass: MockData) {
    mockService.deleteStub(stubDataClass)
  }

  fun verifyStub(stubDataClass: MockData) {
    mockService.verifyStub(stubDataClass)
  }
}