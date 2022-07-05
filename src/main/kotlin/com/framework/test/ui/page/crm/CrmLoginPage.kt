package com.framework.test.ui.page.crm

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$x`
import com.codeborne.selenide.SelenideElement
import com.framework.test.model.ApplicationConfig
import com.framework.test.ui.element.CustomClick.clickButton
import com.framework.test.ui.element.CustomInput.setInputField
import com.framework.test.ui.page.BasePage
import org.apache.logging.log4j.kotlin.Logging
import org.openqa.selenium.By

class CrmLoginPage(applicationConfig: ApplicationConfig) : Logging, BasePage() {
  override val urlPage = applicationConfig.crmLoginEndpoint!!

  private val loginForm: SelenideElement = `$`("form[action='/#/login']")
  private val emailInputField: SelenideElement = `$`(By.name("username"))
  private val passwordInputField: SelenideElement = `$`(By.name("password"))
  private val captchaInputField: SelenideElement = `$`(By.cssSelector("[ng-model='loginData.captcha']"))
  private val submitButton: SelenideElement = `$x`("//button[@type='submit']")

  fun setEmail(value: String?) = setInputField(emailInputField, value)

  fun setPassword(value: String?) = setInputField(passwordInputField, value)

  fun setCaptcha(value: String?) = setInputField(captchaInputField, value)

  fun clickSubmitButton() = clickButton(submitButton)

  fun verifyLoginFormNotVisible() = loginForm.shouldNot(Condition.visible)
}