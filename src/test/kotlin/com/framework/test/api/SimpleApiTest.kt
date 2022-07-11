package com.framework.test.api

import com.framework.test.api.crm.AdminSteps
import com.framework.test.http.client.CustomHttpClient
import com.framework.test.http.verifiers.ResponseNotEmptyVerifier
import com.framework.test.stub.config.CrmSignInMock
import okhttp3.Response
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SimpleApiTest : ApiBaseTest() {

  @Test
  fun `the request for the first step of registration receives not empty cookies and not an empty response body`() {
    val endpoint = "/secure/registration"
    val actualResponse: Response = CustomHttpClient(applicationConfig).get(endpoint)

    ResponseNotEmptyVerifier().apply {
      verifyResponseNotEmptyBody(actualResponse)
      verifyResponseNotEmptyCookieValue(actualResponse, "JSESSIONID")
    }
  }

  @ParameterizedTest
  @ValueSource(strings = ["http://localhost:8081", "https://qa-delivery-solva-kz-master.moneyman.ru"])
  fun `success login in crm system with stub and without stub`(baseUrl: String) {
    val staticMock = CrmSignInMock()
    val endpoint = staticMock.endpoint

    with(applicationConfig.crmUsers?.administrator!!) {
      AdminSteps(applicationConfig, endpoint).apply {
        with(loginCrmWithData(login!!, password!!, captcha!!, baseUrl)) {
          verifyResponseSuccess(this)
        }
      }
    }
  }
}