package com.framework.test.ui.page

import com.codeborne.selenide.WebDriverRunner
import com.framework.test.ui.driver.factory.WebDriverConfigSetterFactory
import org.apache.logging.log4j.kotlin.Logging
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll

open class BaseTest : Logging {
  @BeforeAll
  fun setUp() {
    WebDriverConfigSetterFactory().setDriverConfigFactory().setDriverConfig()
  }

  @AfterAll
  fun tearDown() {
    try {
      WebDriverRunner.getWebDriver().quit()
    } catch (e: IllegalStateException) {
      logger.debug(e.toString())
    }
  }
}