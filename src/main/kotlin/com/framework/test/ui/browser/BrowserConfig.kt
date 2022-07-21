package com.framework.test.ui.browser

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import com.framework.test.constants.CookieType
import com.framework.test.context.applicationConfig
import com.framework.test.context.jSessionId
import org.openqa.selenium.Cookie

class BrowserConfig {

  fun setBaseUrlFromApplicationConfig() {
    Configuration.baseUrl = applicationConfig().getBaseUrl()
  }

  fun setJSessionIdCookieAndRefresh() {
    val cookie = Cookie(CookieType.JSESSIONID.value, jSessionId())
    WebDriverRunner.getWebDriver().manage().addCookie(cookie)
    Selenide.refresh()
  }
}