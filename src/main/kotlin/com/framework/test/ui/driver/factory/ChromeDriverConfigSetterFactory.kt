package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverConfigSetterFactory(
  private val driverConfig: DriverConfig
) : DefaultDriverConfigSetterFactory(driverConfig) {

  override fun setDriverConfig() {
    WebDriverManager.chromedriver().setup()

    Configuration.browser = driverConfig.browser.value
    setDefaultDriverConfig()
  }
}