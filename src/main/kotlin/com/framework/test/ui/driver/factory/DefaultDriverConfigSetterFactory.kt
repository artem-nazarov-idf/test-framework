package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.DriverConfig

abstract class DefaultDriverConfigSetterFactory(private val driverConfig: DriverConfig) : DriverConfigSetter {

  protected fun setDefaultDriverConfig() {
    Configuration.browserSize = driverConfig.browserSize
  }
}