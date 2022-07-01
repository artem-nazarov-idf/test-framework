package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.DriverConfig

abstract class DefaultDriverConfigSetterFactory(private val browserConfig: DriverConfig) {
  protected fun setDefaultDriverConfig() {
    Configuration.browserSize = browserConfig.browserSize
  }
}