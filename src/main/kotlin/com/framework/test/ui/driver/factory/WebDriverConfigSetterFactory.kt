package com.framework.test.ui.driver.factory

import com.framework.test.constants.BrowserType
import com.framework.test.constants.DriverType
import com.framework.test.model.DriverConfig
import com.framework.test.ui.driver.provider.DriverConfigProvider

class WebDriverConfigSetterFactory(
  private val driverConfig: DriverConfig = DriverConfigProvider().getDriverConfigFromFile()
) {
  private val defaultBrowserType: BrowserType by lazy {
    System.getProperty("config.browser.type")?.let {
      BrowserType.valueOf(it)
    } ?: driverConfig.browser
  }
  private val defaultDriverType: DriverType by lazy {
    System.getProperty("config.browser.type")?.let {
      DriverType.valueOf(it)
    } ?: driverConfig.driverType
  }

  fun setDriverConfigFactory(
    driverType: DriverType = defaultDriverType,
    browserType: BrowserType = defaultBrowserType
  ): DriverConfigSetter {
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