package com.framework.test.stub.service

import com.framework.test.stub.builder.StubMappingBuilder
import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.WireMockServer

class WireMockService(
  private val wireMockServer: WireMockServer
) : StubOperation {

  override fun addStub(stubDataClass: MockData) {
    stubDataClass.id = wireMockServer.stubFor(
      StubMappingBuilder(stubDataClass)
        .setRequestMethodFromClass()
        .setPriorityFromClass()
        .setResponseFromClass().build()
    ).id
  }

  override fun deleteStub(stubDataClass: MockData) {
    val stuMapping = wireMockServer.getSingleStubMapping(stubDataClass.id)
    wireMockServer.removeStub(stuMapping)
  }

  override fun verifyStub(stubDataClass: MockData) {
    val actualMappingItemFromServer: String = wireMockServer.getSingleStubMapping(stubDataClass.id)?.id.toString()
    assert(actualMappingItemFromServer != "null") {
      "Mapping not found in actual wire mock service configuration"
    }
  }
}