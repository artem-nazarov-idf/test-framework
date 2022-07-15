package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.constants.BrowserType
import com.framework.test.model.config.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverConfigSetterFactory(
  driverConfig: DriverConfig
) : DefaultDriverConfigSetterFactory(driverConfig) {

  override fun setSpecificDriverConfig() {
    WebDriverManager.chromedriver().setup()

    Configuration.browser = BrowserType.CHROME.browserName
  }
}