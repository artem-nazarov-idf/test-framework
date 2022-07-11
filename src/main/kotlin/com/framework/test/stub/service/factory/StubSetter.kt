package com.framework.test.stub.service.factory

import com.framework.test.stub.config.MockData

interface StubSetter {
  fun addStub(stubDataClass: MockData)
}