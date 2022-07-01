package com.framework.test.ui.driver.factory

import com.framework.test.constants.BrowserType
import com.framework.test.model.DriverConfig
import com.framework.test.ui.driver.provider.DriverConfigProvider

class WebDriverConfigSetterFactory(
  private val driverConfig: DriverConfig = DriverConfigProvider().getDriverConfigFromFile()
) {
  private val browserNameFromFile: String = driverConfig.browser
  private val defaultBrowserType: BrowserType by lazy {
    System.getProperty("config.browser.type")?.let {
      BrowserType.getBrowserTypeByName(it)
    } ?: BrowserType.valueOf(browserNameFromFile)
  }

  fun setDriverConfigFactory(browserType: BrowserType = defaultBrowserType): DriverConfigSetter {
    return when (browserType) {
      BrowserType.REMOTE -> RemoteDriverConfigSetterFactory(driverConfig)
      BrowserType.FIREFOX -> FirefoxDriverConfigSetterFactory()
      BrowserType.CHROME -> ChromeDriverConfigSetterFactory()
    }
  }
}