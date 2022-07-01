package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.constants.BrowserType
import com.framework.test.model.DriverConfig
import com.framework.test.ui.driver.provider.DriverConfigProvider
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxDriverConfigSetterFactory(
  browserConfig: DriverConfig = DriverConfigProvider().getDriverConfigFromFile()
) : DriverConfigSetter, DefaultDriverConfigSetterFactory(browserConfig) {

  override fun setDriverConfig() {
    WebDriverManager.firefoxdriver().setup()

    Configuration.browser = BrowserType.FIREFOX.value
    setDefaultDriverConfig()
  }
}