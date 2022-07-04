package com.framework.test.ui.driver.factory

import com.framework.test.constants.BrowserType
import com.framework.test.constants.DriverType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WebDriverConfigSetterFactoryTest {

  @Test
  fun `WebDriverFactory create ChromeDriverConfigFactory when provided browserType chrome`() {
    val actualDriverConfig = WebDriverConfigSetterFactory().setDriverConfigFactory(DriverType.LOCAL, BrowserType.CHROME)

    Assertions.assertTrue(
      actualDriverConfig is ChromeDriverConfigSetterFactory,
      "[actualDriverConfig] not is chrome"
    )
  }

  @Test
  fun `WebDriverFactory create FirefoxDriverConfigSetterFactory when provided browserType firefox`() {
    val actualDriverConfig =
      WebDriverConfigSetterFactory().setDriverConfigFactory(DriverType.LOCAL, BrowserType.FIREFOX)

    Assertions.assertTrue(
      actualDriverConfig is FirefoxDriverConfigSetterFactory,
      "[actualDriverConfig] not is firefox"
    )
  }

  @Test
  fun `WebDriverFactory use default ChromeDriverConfigSetterFactory when browser not provided`() {
    val actualDriverConfig = WebDriverConfigSetterFactory().setDriverConfigFactory(DriverType.LOCAL)

    Assertions.assertTrue(
      actualDriverConfig is ChromeDriverConfigSetterFactory,
      "[actualDriverConfig] not is chrome"
    )
  }

  @Test
  fun `WebDriverFactory create ChromeDriverConfigSetterFactory when provided browser type is firefox from System property`() {
    System.setProperty("config.browser.type", "chrome")
    val actualDriverConfig: DriverConfigSetter = WebDriverConfigSetterFactory().setDriverConfigFactory(DriverType.LOCAL)

    Assertions.assertTrue(
      actualDriverConfig is ChromeDriverConfigSetterFactory,
      "[$actualDriverConfig] not is chrome"
    )

    System.clearProperty("config.browser.type")
  }
}
