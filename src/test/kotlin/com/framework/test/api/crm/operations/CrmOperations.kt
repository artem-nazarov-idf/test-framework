package com.framework.test.api.crm.operations

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.api.crm.login.controller.CrmAuthorizationController
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.model.config.ApplicationConfig
import okhttp3.Response
import org.junit.jupiter.api.Assertions

class CrmOperations(private val applicationConfig: ApplicationConfig, private val endpoint: String) {

  fun loginToCrm(login: String, password: String, captcha: String, baseUrl: String): Response {
    return CrmAuthorizationController(applicationConfig, endpoint)
      .postCrmAuthorisation(login, password, captcha, baseUrl)
  }

  fun verifyResponseSuccess(response: Response) {
    val actualResponseBody: CrmUserInfoResponse = jacksonObjectMapper().readValue(response.body!!.string())

    Assertions.assertEquals(1000000, actualResponseBody.id)
    Assertions.assertEquals("Администратор", actualResponseBody.localizedRole)
    Assertions.assertEquals(10, actualResponseBody.roleId)
    Assertions.assertEquals("Sergey Shikunets", actualResponseBody.userName)
  }
}