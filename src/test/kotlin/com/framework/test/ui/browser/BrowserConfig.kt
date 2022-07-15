package com.framework.test.ui.browser

import com.codeborne.selenide.Configuration
import com.framework.test.context.applicationConfig

class BrowserConfig() {

  fun setBaseUrlFromApplicationConfig() {
    Configuration.baseUrl = applicationConfig().getBaseUrl()
  }
}