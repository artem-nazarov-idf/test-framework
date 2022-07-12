package com.framework.test.stub.service

import com.framework.test.stub.config.MockData

interface StubOperation {
  fun addStub(stubDataClass: MockData)
  fun deleteStub(stubDataClass: MockData)
  fun verifyStub(stubDataClass: MockData)
}