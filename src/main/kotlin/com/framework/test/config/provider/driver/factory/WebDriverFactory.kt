package com.framework.test.config.provider.driver.factory

import com.framework.test.constants.BrowserType

class WebDriverFactory {
  private val defaultBrowserType: String = System.getProperty("config.browser.type") ?: BrowserType.FIREFOX.value

  fun getDriverConfigReaderFactory(browserType: String = defaultBrowserType): DriverConfigReader {
    return when (browserType) {
      BrowserType.FIREFOX.value -> FirefoxDriverConfigFactory()
      BrowserType.CHROME.value -> ChromeDriverConfigFactory()
      else -> {
        throw IllegalArgumentException("browserType is \"$browserType\", allowed only chrome or firefox")
      }
    }
  }
}