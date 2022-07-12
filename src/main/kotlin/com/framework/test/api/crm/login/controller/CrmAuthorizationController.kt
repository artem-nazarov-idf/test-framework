package com.framework.test.api.crm.login.controller

import com.framework.test.api.crm.login.builder.CrmAuthorizationRequestBuilder
import com.framework.test.http.client.CustomHttpClient
import com.framework.test.model.config.ApplicationConfig
import okhttp3.Response

class CrmAuthorizationController(private val applicationConfig: ApplicationConfig, private val endpoint: String) {
  fun postCrmAuthorisation(
    login: String, password: String, captcha: String, baseUrl: String, remember: Boolean = false
  ): Response {
    val headers: Map<String, String> = mapOf("content-type" to "application/json;charset=UTF-8")
    val body = CrmAuthorizationRequestBuilder().buildRequestBody(login, password, captcha, remember)
    return CustomHttpClient(applicationConfig, baseUrl)
      .post(endpoint, headers, body)
  }
}