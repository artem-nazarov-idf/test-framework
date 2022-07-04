package com.framework.test.ui.driver.factory

import com.framework.test.constants.BrowserType
import com.framework.test.constants.DriverType
import com.framework.test.model.DriverConfig
import com.framework.test.ui.driver.provider.DriverConfigProvider

class WebDriverConfigSetterFactory(
  private val driverConfig: DriverConfig = DriverConfigProvider().getDriverConfigFromFile()
) {
  private val browserNameFromFile: BrowserType = driverConfig.browser
  private val defaultBrowserType: BrowserType by lazy {
    System.getProperty("config.browser.type")?.let {
      BrowserType.getBrowserTypeByName(it)
    } ?: browserNameFromFile
  }

  fun setDriverConfigFactory(driverType: DriverType = DriverType.LOCAL, browserType: BrowserType = defaultBrowserType):
      DriverConfigSetter {
    return when (driverType) {
      DriverType.REMOTE -> RemoteDriverConfigSetterFactory(driverConfig)
      DriverType.LOCAL -> {
        return when (browserType) {
          BrowserType.CHROME -> ChromeDriverConfigSetterFactory(driverConfig)
          BrowserType.FIREFOX -> FirefoxDriverConfigSetterFactory(driverConfig)
        }
      }
    }
  }
}