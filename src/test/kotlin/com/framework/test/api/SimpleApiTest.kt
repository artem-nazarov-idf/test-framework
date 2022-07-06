package com.framework.test.api

import com.framework.test.api.verifiers.ResponseNotEmptyVerifier
import com.framework.test.http.client.CustomHttpClient
import okhttp3.Response
import org.junit.jupiter.api.Test

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
}