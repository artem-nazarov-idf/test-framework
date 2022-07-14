package com.framework.test.stub.builder

import com.framework.test.constants.RequestMethods
import com.framework.test.stub.config.MockData
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock

class StubMappingBuilder(
  private val stubDataClass: MockData,
) {
  private lateinit var stubMapping: MappingBuilder

  fun setRequestMethodFromClass() = apply {
    stubMapping = when (stubDataClass.method) {
      RequestMethods.POST -> WireMock.post(WireMock.urlPathMatching(stubDataClass.endpoint))
      RequestMethods.GET -> WireMock.get(WireMock.urlPathMatching(stubDataClass.endpoint))
      RequestMethods.DELETE -> WireMock.delete(WireMock.urlPathMatching(stubDataClass.endpoint))
    }
  }

  fun setPriorityFromClass() = apply { stubMapping.atPriority(stubDataClass.priority) }
  fun setResponseFromClass() = apply {
    stubMapping.willReturn(
      StubResponseBuilder().addParametersToResponse(stubDataClass).build()
    )
  }

  fun build(): MappingBuilder = stubMapping // todo плохо, можно вернуть в setResponseFromClass и надо завернуть в
// общую функцию.
}