package com.framework.test.api.crm.operations

import com.framework.test.api.crm.login.controller.CrmAuthorizationController
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.context.administrator
import com.framework.test.context.applicationConfig
import org.junit.jupiter.api.Assertions

class CrmOperations(private val endpoint: String) {

  fun loginToCrm(
    login: String = administrator().login!!, password: String = administrator().password!!, captcha:
    String = administrator().captcha!!,
    baseUrl: String = applicationConfig().getBaseUrl()
  ): CrmUserInfoResponse {
    return CrmAuthorizationController(endpoint)
      .postCrmAuthorisation(login, password, captcha, baseUrl)
  }

  fun verifyResponseSuccess(actualResponseBody: CrmUserInfoResponse) {
    Assertions.assertEquals(1000000, actualResponseBody.id)
    Assertions.assertEquals("Администратор", actualResponseBody.localizedRole)
    Assertions.assertEquals(10, actualResponseBody.roleId)
    Assertions.assertEquals("Sergey Shikunets", actualResponseBody.userName)
  }
}