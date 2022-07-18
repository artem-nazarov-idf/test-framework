package com.framework.test.ui.page.crm

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner
import com.framework.test.context.applicationConfig
import com.framework.test.context.jSessionId
import com.framework.test.ui.element.CustomDropDown.dropDownVisible
import com.framework.test.ui.page.BasePage
import org.apache.logging.log4j.kotlin.Logging
import org.openqa.selenium.Cookie

class CrmAdminHomePage() : Logging, BasePage() {
  override val urlPage = applicationConfig().crmStartEndpoint!!

  private val mainNavDropdown: SelenideElement = `$`("#mainNav")

  fun openPageWithSessionCookie() {
    openPage()
    val cookie = Cookie("JSESSIONID", jSessionId())
    WebDriverRunner.getWebDriver().manage().addCookie(cookie)
    Selenide.refresh()
  }

  fun evaluateDropDownVisible() = dropDownVisible(mainNavDropdown)
}