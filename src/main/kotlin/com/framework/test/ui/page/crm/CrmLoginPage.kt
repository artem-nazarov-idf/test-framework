package com.framework.test.ui.page.crm

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$x`
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.SelenideElement
import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.model.ApplicationConfig
import com.framework.test.ui.element.CustomClick.clickButton
import com.framework.test.ui.element.CustomInput.setInputField
import org.apache.logging.log4j.kotlin.Logging
import org.openqa.selenium.By

class CrmLoginPage : Logging {

  private val applicationConfig: ApplicationConfig by lazy {
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()
  }

  private val crmLoginPageAddress: String = applicationConfig.crmLoginEndpoint ?: "crmLoginPageAddress equal null"
  private val hostPageAddress: String = applicationConfig.host ?: "hostPageAddress equal null"
  val emailAdminValue: String = applicationConfig.crmUsers?.administrator?.login ?: "emailAdminValue equal null"
  val passwordAdminValue: String =
    applicationConfig.crmUsers?.administrator?.password ?: "passwordAdminValue equal null"
  val captchaAdminValue: String = applicationConfig.crmUsers?.administrator?.captcha ?: "captchaAdminValue equal null"

  private val emailInputField: SelenideElement = `$`(By.name("username"))
  private val passwordInputField: SelenideElement = `$`(By.name("password"))
  private val captchaInputField: SelenideElement = `$`(By.cssSelector("[ng-model='loginData.captcha']"))
  private val submitButton: SelenideElement = `$x`("//button[@type='submit']")

  fun openCrmLoginPage() {
    logger.info("open crm login page")
    open("${hostPageAddress}${crmLoginPageAddress}")
  }

  fun setEmail(value: String) = setInputField(emailInputField, value)

  fun setPassword(value: String) = setInputField(passwordInputField, value)

  fun setCaptcha(value: String) = setInputField(captchaInputField, value)

  fun clickSubmitButton() = clickButton(submitButton)
}