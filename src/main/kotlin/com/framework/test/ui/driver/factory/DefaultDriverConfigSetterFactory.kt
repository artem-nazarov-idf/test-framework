package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.config.DriverConfig

abstract class DefaultDriverConfigSetterFactory(private val driverConfig: DriverConfig) : DriverConfigSetter {

  private fun setDefaultDriverConfig() {
    Configuration.browserSize = driverConfig.browserSize
  }

  override fun setDriverConfig() {
    setSpecificDriverConfig()
    setDefaultDriverConfig()
  }

  abstract fun setSpecificDriverConfig()
}