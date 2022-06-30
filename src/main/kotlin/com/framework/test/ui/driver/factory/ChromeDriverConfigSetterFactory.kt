package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.DriverConfig
import com.framework.test.ui.driver.provider.DriverConfigProvider
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverConfigSetterFactory(
  private val browserConfig: DriverConfig = DriverConfigProvider().getDriverConfigFromFile()
) : DriverConfigSetter {

  override fun setDriverConfig() {
    WebDriverManager.chromedriver().setup()

    Configuration.baseUrl = "https://"
    Configuration.browser = "chrome"
    Configuration.browserSize = browserConfig.browserSize
  }
}