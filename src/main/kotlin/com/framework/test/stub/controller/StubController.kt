package com.framework.test.stub.controller

import com.framework.test.stub.config.MockData
import com.framework.test.stub.service.WireMockService

class StubController {
  private val mockService = WireMockService()

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