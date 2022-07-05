package com.framework.test.ui.page

import com.framework.test.ui.page.crm.CrmAdminHomePage
import com.framework.test.ui.page.crm.CrmLoginPage
import org.junit.jupiter.api.Test

class CrmLoginTest : BaseUITest() {
  @Test
  fun `success login crm to administrator`() {
    with(applicationConfig.crmUsers?.administrator!!) {
      CrmLoginPage(applicationConfig).apply {
        openPage()
        setEmail(login)
        setPassword(password)
        setCaptcha(captcha)
        clickSubmitButton()
        verifyLoginFormNotVisible()
      }
    }
    CrmAdminHomePage(applicationConfig).evaluateDropDownVisible()
  }
}