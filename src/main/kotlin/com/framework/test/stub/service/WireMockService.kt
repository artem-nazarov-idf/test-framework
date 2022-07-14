package com.framework.test.stub.service

import com.framework.test.stub.builder.StubMappingBuilder
import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping

class WireMockService(
  private val wireMockClient: WireMock
) : StubOperation {

  override fun addStub(stubDataClass: MockData) {
    val mappingBuilderFromClass: MappingBuilder = StubMappingBuilder(stubDataClass).buildStubMappingFromClass()
    stubDataClass.id = wireMockClient.register(mappingBuilderFromClass).id
  }

  override fun deleteStub(stubDataClass: MockData) {
    val stuMapping: StubMapping = wireMockClient.getStubMapping(stubDataClass.id).item
    wireMockClient.removeStubMapping(stuMapping)
  }

  override fun verifyStub(stubDataClass: MockData) {
    val actualMappingItemFromServer: String = wireMockClient.getStubMapping(stubDataClass.id).item?.id.toString()
    assert(actualMappingItemFromServer != "null") {
      "Mapping not found in actual wire mock service configuration"
    }
  }
}