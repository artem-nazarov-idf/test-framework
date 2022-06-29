package com.framework.test.config.provider.driver.factory

import com.framework.test.constants.BrowserType

class WebDriverFactory {
  private val defaultBrowserType: BrowserType by lazy {
    System.getProperty("config.file.type")?.let { BrowserType.from(it) } ?: BrowserType.FIREFOX
  }

  fun getDriverConfigReaderFactory(browserType: BrowserType = defaultBrowserType): DriverConfigReader {
    return when (browserType) {
      BrowserType.FIREFOX -> FirefoxDriverConfigFactory()
      BrowserType.CHROME -> ChromeDriverConfigFactory()
    }
  }
}