package com.framework.test.ui.page

import com.codeborne.selenide.WebDriverRunner
import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext
import com.framework.test.context.dynamicContext
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.ui.browser.BrowserConfig
import com.framework.test.ui.driver.factory.WebDriverConfigSetterFactory
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUiTest {
  protected val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()

  init {
    DynamicContextHolder.initContext(MyDynamicContext())
  }

  protected var dynamicContext: MyDynamicContext
    get() {
      return dynamicContext()
    }
    set(value) {
      DynamicContextHolder.initContext(value)
    }

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