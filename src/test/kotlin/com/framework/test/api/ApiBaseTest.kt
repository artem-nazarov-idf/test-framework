package com.framework.test.api

import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.model.config.StubConfig
import com.framework.test.stub.StubConfigProvider
import com.framework.test.stub.config.CrmSignInMock
import com.framework.test.stub.service.factory.StubSetterFactory
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class ApiBaseTest {
  private lateinit var wireMockServer: WireMockServer
  private val stubServiceConfig: StubConfig = StubConfigProvider().getDriverConfigFromFile()
  protected val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()

  @BeforeAll
  fun runWireMock() {
    wireMockServer = WireMockServer(WireMockConfiguration.options().port(stubServiceConfig.stubPort))
    wireMockServer.start()
    StubSetterFactory(CrmSignInMock(), wireMockServer).setStub()
  }

  @AfterAll
  fun stopWireMock() = wireMockServer.stop()
}