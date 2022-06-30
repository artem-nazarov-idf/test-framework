package com.framework.test.ui.page

import com.framework.test.ui.page.crm.CrmAdminHomePage
import com.framework.test.ui.page.crm.CrmLoginPage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CrmLoginTest : BaseTest() {

  @Test
  fun `success login crm to administrator`() {
    CrmLoginPage().apply {
      openCrmLoginPage()
      setEmail(emailAdminValue)
      setPassword(passwordAdminValue)
      setCaptcha(captchaAdminValue)
      clickSubmitButton()
    }
    CrmAdminHomePage().evaluateDropDownVisible()
  }
}