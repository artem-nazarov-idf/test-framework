package com.framework.test.ui.page.crm

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import com.framework.test.ui.element.CustomDropDown.dropDownVisible
import com.framework.test.ui.page.BasePage
import org.apache.logging.log4j.kotlin.Logging

class CrmAdminHomePage : Logging, BasePage() {
  override val urlPage = "/secure/new-admin/index.html#"

  private val mainNavDropdown: SelenideElement = `$`("#mainNav")

  fun evaluateDropDownVisible() = dropDownVisible(mainNavDropdown)
}