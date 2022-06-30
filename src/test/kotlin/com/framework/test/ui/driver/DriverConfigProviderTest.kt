package com.framework.test.ui.driver

import com.framework.test.ui.driver.provider.DriverConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DriverConfigProviderTest {
  @Test
  fun getDriverConfigFromFileTest() {
    val actualDriverConfig = DriverConfigProvider().getDriverConfigFromFile()

    Assertions.assertEquals("1920x1080", actualDriverConfig.browserSize)
  }
}