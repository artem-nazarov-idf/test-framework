package com.framework.test.config.provider.driver.factory

import com.framework.test.constants.BrowserType

class WebDriverConfigReaderFactory {
  private val defaultBrowserType: BrowserType by lazy {
    System.getProperty("config.browser.type")?.let { BrowserType.from(it) } ?: BrowserType.FIREFOX
  }

  fun setDriverConfigFactory(browserType: BrowserType = defaultBrowserType): DriverConfigSetter {
    return when (browserType) {
      BrowserType.FIREFOX -> FirefoxDriverConfigReaderFactory()
      BrowserType.CHROME -> ChromeDriverConfigReaderFactory()
    }
  }
}