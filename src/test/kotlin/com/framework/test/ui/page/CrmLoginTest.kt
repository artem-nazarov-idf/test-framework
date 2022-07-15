package com.framework.test.ui.page

import com.framework.test.context.administrator
import com.framework.test.ui.page.crm.CrmAdminHomePage
import com.framework.test.ui.page.crm.CrmLoginPage
import org.junit.jupiter.api.Test

class CrmLoginTest : BaseUiTest() {
  @Test
  fun `success login crm to administrator`() {
    with(administrator()) {
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