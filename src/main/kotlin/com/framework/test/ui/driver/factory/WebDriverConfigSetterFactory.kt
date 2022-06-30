package com.framework.test.ui.driver.factory

import com.framework.test.constants.BrowserType

class WebDriverConfigSetterFactory {
  private val defaultBrowserType: BrowserType by lazy {
    System.getProperty("config.browser.type")?.let { BrowserType.from(it) } ?: BrowserType.CHROME
  }

  fun setDriverConfigFactory(browserType: BrowserType = defaultBrowserType): DriverConfigSetter {
    return when (browserType) {
      BrowserType.FIREFOX -> FirefoxDriverConfigSetterFactory()
      BrowserType.CHROME -> ChromeDriverConfigSetterFactory()
    }
  }
}