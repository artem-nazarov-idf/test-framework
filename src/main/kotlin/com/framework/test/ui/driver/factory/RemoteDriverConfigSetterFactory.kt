package com.framework.test.ui.driver.factory

import com.codeborne.selenide.Configuration
import com.framework.test.model.DriverConfig
import org.openqa.selenium.remote.DesiredCapabilities

class RemoteDriverConfigSetterFactory(
  private val driverConfig: DriverConfig
) : DriverConfigSetter {

  private fun getDefaultCapabilities(): DesiredCapabilities {
    val caps = DesiredCapabilities()
    caps.setCapability("applicationName", driverConfig.gridNodIdName)
    caps.setCapability("enableVNC", true)
    return caps
  }

  override fun setDriverConfig() {
    ChromeDriverConfigSetterFactory().setDriverConfig()
    Configuration.remote = "http://${driverConfig.webdriverHost}:${driverConfig.webdriverPort}/wd/hub"
    Configuration.browserCapabilities.merge(getDefaultCapabilities())
  }
}