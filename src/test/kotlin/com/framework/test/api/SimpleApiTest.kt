package com.framework.test.api

import com.framework.test.http.client.CustomHttpClient
import com.framework.test.http.verifiers.ResponseNotEmptyVerifier
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import okhttp3.Response
import org.junit.jupiter.api.Test

@WireMockTest(httpPort = 8080)
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

  @Test
  fun `success login in crm system with wrong parameters and stub`(wmRuntimeInfo: WireMockRuntimeInfo) {
    val endpoint = "/secure/rest/sign/in"

    stubFor(
      get(urlPathMatching("/baeldung/.*"))
        .willReturn(
          aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("\"testing-library\": \"WireMock\"")
        )
    );

//    stubFor(
//      post(urlEqualTo(endpoint)).willReturn(aResponse().withBody("Welcome to Baeldung!")))

    val wireMock: WireMock = wmRuntimeInfo.wireMock
    wireMock.register(
      get(urlPathMatching("/baeldung/.*"))
        .willReturn(
          aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("\"testing-library\": \"WireMock\"")
        )
    )

//    val headers: Map<String, String> = mapOf("content-type" to "application/json;charset=UTF-8")
//    val body = "{\"login\":\"admmin\",\"password\":\"nimda201\",\"captcha\":\"11111\",\"remember\":false}"
//      .toRequestBody()
//    val actualResponse: Response = CustomHttpClient(applicationConfig).post(endpoint, headers,
//      body)

    val actualResponse: Response = CustomHttpClient(applicationConfig)
      .get("/baeldung/wiremock")

    ResponseNotEmptyVerifier().apply {
      verifyResponseNotEmptyBody(actualResponse)
      verifyResponseNotEmptyCookieValue(actualResponse, "JSESSIONID")
    }
  }
}