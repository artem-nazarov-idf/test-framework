package com.framework.test.ui.page

import com.codeborne.selenide.WebDriverRunner
import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.model.ApplicationConfig
import com.framework.test.ui.browser.BrowserConfig
import com.framework.test.ui.driver.factory.WebDriverConfigSetterFactory
import org.apache.logging.log4j.kotlin.Logging
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUITest : Logging {
  protected val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()

  @BeforeAll
  fun setUp() {
    WebDriverConfigSetterFactory().setDriverConfigFactory().setDriverConfig()
    BrowserConfig(applicationConfig).setBaseUrlFromApplicationConfig()
  }

  @AfterAll
  fun tearDown() {
    if (WebDriverRunner.hasWebDriverStarted()) {
      WebDriverRunner.getWebDriver().quit()
    }
  }
}