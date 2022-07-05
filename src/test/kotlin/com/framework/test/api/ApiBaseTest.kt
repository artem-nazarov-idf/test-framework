package com.framework.test.api

import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.model.ApplicationConfig
import org.junit.jupiter.api.BeforeEach

abstract class ApiBaseTest {
  protected val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()

  @BeforeEach
  fun clearCookie() {
  }
}