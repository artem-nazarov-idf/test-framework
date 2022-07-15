package com.framework.test.ui.page

import com.codeborne.selenide.WebDriverRunner
import com.framework.test.context.constant.MyStaticContext
import com.framework.test.context.constant.StaticContextHolder
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext
import com.framework.test.context.dynamicContext
import com.framework.test.context.staticContext
import com.framework.test.ui.browser.BrowserConfig
import com.framework.test.ui.driver.factory.WebDriverConfigSetterFactory
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUiTest {

  protected var staticContext: MyStaticContext
    get() {
      return staticContext()
    }
    set(value) {
      StaticContextHolder.initContext(value)
    }

  protected var dynamicContext: MyDynamicContext
    get() {
      return dynamicContext()
    }
    set(value) {
      DynamicContextHolder.initContext(value)
    }

  init {
    dynamicContext = MyDynamicContext()
    staticContext = MyStaticContext()
  }

  @BeforeAll
  fun setUp() {
    WebDriverConfigSetterFactory().setDriverConfigFactory().setDriverConfig()
    BrowserConfig().setBaseUrlFromApplicationConfig()
//    dynamicContext = MyDynamicContext()
//    staticContext = MyStaticContext()
  }

  @AfterAll
  fun tearDown() {
    if (WebDriverRunner.hasWebDriverStarted()) {
      WebDriverRunner.getWebDriver().quit()
    }
  }
}