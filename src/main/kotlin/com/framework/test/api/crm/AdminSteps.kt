package com.framework.test.api.crm

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.http.client.CustomHttpClient
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.model.response.CrmUserInfo
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.junit.jupiter.api.Assertions

class AdminSteps(private val applicationConfig: ApplicationConfig, private val endpoint: String) {

  fun loginCrmWithData(login: String, password: String, captcha: String, basseUrl: String): Response {
    val headers: Map<String, String> = mapOf("content-type" to "application/json;charset=UTF-8")
    val body =
      "{\"login\":\"$login\",\"password\":\"$password\",\"captcha\":\"$captcha\",\"remember\":false}".toRequestBody()
    // составляем тело и голову запроса

    return CustomHttpClient(applicationConfig, basseUrl)
      .post(endpoint, headers, body) // отправляем запрос.
  }

  fun verifyResponseSuccess(response: Response) {
    val actualResponseBody: CrmUserInfo = jacksonObjectMapper().readValue(response.body!!.string())

    Assertions.assertEquals(1000000, actualResponseBody.id)
    Assertions.assertEquals("Администратор", actualResponseBody.localizedRole)
    Assertions.assertEquals(10, actualResponseBody.roleId)
    Assertions.assertEquals("Sergey Shikunets", actualResponseBody.userName)
  }
}