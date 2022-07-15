package com.framework.test.api.testWithStub

import com.framework.test.api.ApiBaseTest
import com.framework.test.context.stubConfig
import com.framework.test.stub.controller.StubController
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest : ApiBaseTest() {
  private val wireMockServer: WireMockServer by lazy {
    WireMockServer(WireMockConfiguration.options().port(stubConfig().port))
  }
  protected val stubController: StubController by lazy { StubController() }

  @BeforeAll
  fun runWireMock() {
    wireMockServer.start()
  }

  @AfterAll
  fun stopWireMock() {
    wireMockServer.stop()
  }
}