package com.framework.test.ui.page.crm

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner
import com.framework.test.context.jSessionIdValue
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.ui.element.CustomDropDown.dropDownVisible
import com.framework.test.ui.page.BasePage
import org.apache.logging.log4j.kotlin.Logging
import org.openqa.selenium.Cookie

class CrmAdminHomePage(applicationConfig: ApplicationConfig) : Logging, BasePage() {
  override val urlPage = applicationConfig.crmStartEndpoint!!

  private val mainNavDropdown: SelenideElement = `$`("#mainNav")

  fun openPageWithSessionCookie() {
    openPage()
    val cookie = Cookie("JSESSIONID", jSessionIdValue())
    WebDriverRunner.getWebDriver().manage().addCookie(cookie)
//    Selenide.refresh()
  }

  fun evaluateDropDownVisible() = dropDownVisible(mainNavDropdown)
}