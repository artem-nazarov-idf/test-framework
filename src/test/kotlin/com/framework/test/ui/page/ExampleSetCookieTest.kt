package com.framework.test.ui.page

import com.framework.test.api.crm.operations.CrmOperations
import com.framework.test.context.administrator
import com.framework.test.ui.page.crm.CrmAdminHomePage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExampleSetCookieTest : BaseUiTest() {
  @BeforeEach
  fun setCookie() {
    with(administrator()) {
      CrmOperations("/secure/rest/sign/in").apply {
        with(getCookieFromResponse(login!!, password!!, captcha!!, "JSESSIONID")) {
          dynamicContext.setJSessionIdValue(this)
        }
      }
    }
  }

  @Test
  fun `success open crm page with right cookie`() {
    CrmAdminHomePage().apply {
      openPageWithSessionCookie()
      evaluateDropDownVisible()
    }
  }
}
