package com.framework.test.config.provider.driver.factory

import com.framework.test.constants.BrowserType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WebDriverConfigReaderFactoryTest {

  @Test
  fun `WebDriverFactory create ChromeDriverConfigFactory when provided browserType chrome`() {
    val actualDriverConfig = WebDriverConfigReaderFactory().setDriverConfigFactory(BrowserType.CHROME)

    Assertions.assertTrue(
      actualDriverConfig is ChromeDriverConfigReaderFactory,
      "[actualDriverConfig] not is chrome"
    )
  }

  @Test
  fun `WebDriverFactory create ChromeDriverConfigFactory when provided browserType firefox`() {
    val actualDriverConfig = WebDriverConfigReaderFactory().setDriverConfigFactory(BrowserType.FIREFOX)

    Assertions.assertTrue(
      actualDriverConfig is FirefoxDriverConfigReaderFactory,
      "[actualDriverConfig] not is firefox"
    )
  }

  @Test
  fun `WebDriverFactory use default browser chrome when browser not provided`() {
    val actualDriverConfig = WebDriverConfigReaderFactory().setDriverConfigFactory()

    Assertions.assertTrue(
      actualDriverConfig is ChromeDriverConfigReaderFactory,
      "[actualDriverConfig] not is chrome"
    )
  }

  @Test
  fun `WebDriverFactory create ChromeDriverConfigFactory when provided browser type is firefox from System property`() {
    System.setProperty("config.browser.type", "firefox")
    val actualDriverConfig: DriverConfigSetter = WebDriverConfigReaderFactory().setDriverConfigFactory()

    Assertions.assertTrue(
      actualDriverConfig is FirefoxDriverConfigReaderFactory,
      "[$actualDriverConfig] not is firefox"
    )

    System.clearProperty("config.browser.type")
  }
}
