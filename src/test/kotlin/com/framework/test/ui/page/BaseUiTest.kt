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

//  protected var staticContext: MyStaticContext
//    get() {
//      return staticContext()
//    }
//    set(value) {
//      StaticContextHolder.initContext(value)
//    }
//
//  protected var dynamicContext: MyDynamicContext
//    get() {
//      return dynamicContext()
//    }
//    set(value) {
//      DynamicContextHolder.initContext(value)
//    }
//
//  init {
//    dynamicContext = MyDynamicContext()
//    staticContext = MyStaticContext()
//  }

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