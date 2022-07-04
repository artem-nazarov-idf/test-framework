package com.framework.test.ui.page

import com.framework.test.ui.page.crm.CrmAdminHomePage
import com.framework.test.ui.page.crm.CrmLoginPage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CrmLoginTest : BaseTest() {
  @Test
  fun `success login crm to administrator`() {
    with(applicationConfig.crmUsers?.administrator!!) {
      CrmLoginPage().apply {
        openPage()
        setEmail(login)
        setPassword(password)
        setCaptcha(captcha)
        clickSubmitButton()
        verifyLoginFormNotVisible()
      }
    }
    CrmAdminHomePage().evaluateDropDownVisible()
  }
}