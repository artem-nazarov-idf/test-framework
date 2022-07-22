package com.framework.test.api.crm.login.builder

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.framework.test.api.crm.login.model.request.CrmAuthorizationRequest
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class CrmAuthorizationRequestBuilder {
  val headers: MutableMap<String, String> = mutableMapOf()
  var body: RequestBody = "".toRequestBody()

  fun addHeader(key: String, value: String): CrmAuthorizationRequestBuilder = apply { headers[key] = value }

  fun addRequestBody(
    login: String,
    password: String,
    captcha: String
  ): CrmAuthorizationRequestBuilder = apply {
    val crmAuthorizationRequest = CrmAuthorizationRequest(
      login = login,
      password = password,
      captcha = captcha
    )
    body = jacksonObjectMapper().writeValueAsString(crmAuthorizationRequest).toRequestBody()
  }
}