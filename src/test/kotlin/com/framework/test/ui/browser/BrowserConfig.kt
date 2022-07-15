package com.framework.test.ui.browser

import com.codeborne.selenide.Configuration
import com.framework.test.model.config.ApplicationConfig

class BrowserConfig(private val applicationConfig: ApplicationConfig) {

  fun setBaseUrlFromApplicationConfig() {
    Configuration.baseUrl = applicationConfig.getBaseUrl()
  }
}