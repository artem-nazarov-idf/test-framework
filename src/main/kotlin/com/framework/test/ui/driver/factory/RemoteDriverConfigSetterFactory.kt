package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.constants.BrowserType
import com.framework.test.model.DriverConfig
import org.openqa.selenium.remote.DesiredCapabilities

class RemoteDriverConfigSetterFactory(
  private val driverConfig: DriverConfig
) : DefaultDriverConfigSetterFactory(driverConfig) {

  private fun getDefaultCapabilities(): DesiredCapabilities {
    val caps = DesiredCapabilities()
    caps.setCapability("applicationName", driverConfig.gridNodIdName)
    caps.setCapability("enableVNC", true)
    return caps
  }

  override fun setDriverConfig() {
    Configuration.remote = "http://${driverConfig.localhost}:${driverConfig.webdriverPort}/wd/hub"
    Configuration.browserCapabilities.merge(getDefaultCapabilities())

    return when (driverConfig.browser) {
      BrowserType.CHROME -> ChromeDriverConfigSetterFactory(driverConfig).setDriverConfig()
      BrowserType.FIREFOX -> FirefoxDriverConfigSetterFactory(driverConfig).setDriverConfig()
    }
  }
}