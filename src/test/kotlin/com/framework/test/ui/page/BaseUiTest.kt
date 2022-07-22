package com.framework.test.ui.page

import com.codeborne.selenide.WebDriverRunner
import com.framework.test.BaseTest
import com.framework.test.ui.browser.BrowserConfig
import com.framework.test.ui.driver.factory.WebDriverConfigSetterFactory
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUiTest : BaseTest() {

  @BeforeAll
  fun setUp() {
    WebDriverConfigSetterFactory().setDriverConfigFactory().setDriverConfig()
    BrowserConfig.setBaseUrlFromApplicationConfig()
  }

  @AfterAll
  fun tearDown() {
    if (WebDriverRunner.hasWebDriverStarted()) {
      WebDriverRunner.getWebDriver().quit()
    }
  }
}