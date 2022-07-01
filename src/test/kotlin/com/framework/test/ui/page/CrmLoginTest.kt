package com.framework.test.ui.page

import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.model.ApplicationConfig
import com.framework.test.ui.page.crm.CrmAdminHomePage
import com.framework.test.ui.page.crm.CrmLoginPage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CrmLoginTest : BaseTest() {
  val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()

  val emailAdminValue: String = applicationConfig.crmUsers?.administrator?.login ?: "emailAdminValue equal null"
  val passwordAdminValue: String =
    applicationConfig.crmUsers?.administrator?.password ?: "passwordAdminValue equal null"
  val captchaAdminValue: String = applicationConfig.crmUsers?.administrator?.captcha ?: "captchaAdminValue equal null"

  @Test
  fun `success login crm to administrator`() {
    CrmLoginPage().apply {
      openPage()
      setEmail(emailAdminValue)
      setPassword(passwordAdminValue)
      setCaptcha(captchaAdminValue)
      clickSubmitButton()
    }
    CrmAdminHomePage().evaluateDropDownVisible()
  }
}