package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.constants.BrowserType
import com.framework.test.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxDriverConfigSetterFactory(
  driverConfig: DriverConfig
) : DefaultDriverConfigSetterFactory(driverConfig) {

  override fun setSpecificDriverConfig() {
    WebDriverManager.firefoxdriver().setup()
    Configuration.browser = BrowserType.FIREFOX.browserName
  }
}