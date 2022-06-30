package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.DriverConfig
import com.framework.test.ui.driver.provider.DriverConfigProvider
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxDriverConfigSetterFactory(
  private val browserConfig: DriverConfig = DriverConfigProvider().getDriverConfigFromFile()
) : DriverConfigSetter {

  override fun setDriverConfig() {
    WebDriverManager.firefoxdriver().setup()

    Configuration.baseUrl = "https://"
    Configuration.browser = "firefox"
    Configuration.browserSize = browserConfig.browserSize
  }
}