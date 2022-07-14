package com.framework.test.stub.builder

import com.framework.test.constants.RequestMethods
import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock

class StubMappingBuilder(
  private val stubDataClass: MockData
) {
  private lateinit var stubMapping: MappingBuilder

  fun buildStubMappingFromClass(): MappingBuilder {
    return setRequestMethodFromClass().setPriorityFromClass().setResponseFromClass().build()
  }

  private fun setRequestMethodFromClass(): StubMappingBuilder = apply {
    stubMapping = when (stubDataClass.method) {
      RequestMethods.POST -> WireMock.post(WireMock.urlPathMatching(stubDataClass.endpoint))
      RequestMethods.GET -> WireMock.get(WireMock.urlPathMatching(stubDataClass.endpoint))
      RequestMethods.DELETE -> WireMock.delete(WireMock.urlPathMatching(stubDataClass.endpoint))
    }
  }

  private fun setPriorityFromClass(): StubMappingBuilder = apply { stubMapping.atPriority(stubDataClass.priority) }
  private fun setResponseFromClass(): StubMappingBuilder = apply {
    stubMapping.willReturn(
      StubResponseBuilder().addParametersToResponse(stubDataClass).build()
    )
  }

  private fun build(): MappingBuilder = stubMapping
}