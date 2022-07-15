package com.framework.test.api.crm.operations

import com.framework.test.api.crm.login.controller.CrmAuthorizationController
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.context.administrator
import com.framework.test.http.converters.CookieConverter
import org.junit.jupiter.api.Assertions

class CrmOperations(private val endpoint: String) {

  fun loginToCrm(login: String, password: String, captcha: String, baseUrl: String): CrmUserInfoResponse {
    return CrmAuthorizationController(endpoint)
      .postCrmAuthorisation(login, password, captcha, baseUrl)
  }

  fun verifyResponseSuccess(actualResponseBody: CrmUserInfoResponse) {
    Assertions.assertEquals(1000000, actualResponseBody.id)
    Assertions.assertEquals("Администратор", actualResponseBody.localizedRole)
    Assertions.assertEquals(10, actualResponseBody.roleId)
    Assertions.assertEquals("Sergey Shikunets", actualResponseBody.userName)
  }

  fun getCookieFromResponse(
    login: String = administrator().login!!, password: String = administrator().password!!, captcha: String =
      administrator().captcha!!, cookieName: String
  ): String {
    val response = CrmAuthorizationController(endpoint)
      .postCrmAuthorisationReturnResponse(login, password, captcha)
    return CookieConverter().getCookieValueFromResponse(response, cookieName)
  }
}