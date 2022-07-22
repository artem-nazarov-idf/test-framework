package com.framework.test.ui.browser

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import com.framework.test.context.applicationConfig
import org.openqa.selenium.Cookie

object BrowserConfig {

  fun setBaseUrlFromApplicationConfig() {
    Configuration.baseUrl = applicationConfig().getBaseUrl()
  }

  fun setBrowserCookieAndRefresh(cookie: Cookie?) {
    WebDriverRunner.getWebDriver().manage().addCookie(cookie)
    Selenide.refresh()
  }
}