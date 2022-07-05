package com.framework.test.api

import com.framework.test.http.client.CustomHttpClient
import okhttp3.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleApiTest : ApiBaseTest() {
  private val url: String = "https://${applicationConfig.host}/secure/registration"
//  private val url: String = "https://httpbin.org/status/200"

  @Test
  fun `the request for the first step of registration receives not empty cookies and not an empty response body`() {
    val actualResponse: Response = CustomHttpClient().get(url)

    Assertions.assertTrue(actualResponse.body!!.byteString().size > 0)
    Assertions.assertTrue(actualResponse.headers["set-cookie"].toString().contains("JSESSIONID"))
  }
}