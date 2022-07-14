package com.framework.test.stub.controller

import com.framework.test.stub.config.MockData
import com.framework.test.stub.service.StubOperation

class StubController(
  private val mockService: StubOperation
) {

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