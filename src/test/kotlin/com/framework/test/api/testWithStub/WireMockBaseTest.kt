package com.framework.test.api.testWithStub

import com.framework.test.api.ApiBaseTest
import com.framework.test.stub.controller.StubController
import com.framework.test.stub.service.WireMockService
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest : ApiBaseTest() {
  private val wireMockServer: WireMockServer by lazy {
    WireMockServer(WireMockConfiguration.options().port(applicationConfig.stub.port))
  }
  private val wireMockClient: WireMock by lazy { WireMock(applicationConfig.stub.host, applicationConfig.stub.port) }
  private val wireMockService: WireMockService by lazy { WireMockService(wireMockClient) }
  protected val stubController: StubController by lazy { StubController(wireMockService) }

  @BeforeAll
  fun runWireMock() {
    wireMockServer.start()
  }

  @AfterAll
  fun stopWireMock() {
    wireMockServer.stop()
  }
}