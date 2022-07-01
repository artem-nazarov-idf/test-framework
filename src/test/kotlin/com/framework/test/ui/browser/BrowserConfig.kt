package com.framework.test.ui.browser

import com.codeborne.selenide.Configuration
import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.model.ApplicationConfig

class BrowserConfig(
  private val applicationConfig: ApplicationConfig = ApplicationConfigReaderFactory().getAppConfigReaderFactory()
    .getApplicationConfigFromFile()
) {

  fun setBaseUrlFromApplicationConfig() {
    Configuration.baseUrl = "https://${applicationConfig.host}"
  }
}