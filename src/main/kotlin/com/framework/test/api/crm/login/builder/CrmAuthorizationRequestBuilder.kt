package com.framework.test.api.crm.login.builder

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.framework.test.api.crm.login.model.request.CrmAuthorizationRequest
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class CrmAuthorizationRequestBuilder {
  private val mapper = jacksonObjectMapper()
  val headers: MutableMap<String, String> = mutableMapOf()
  lateinit var body: RequestBody

  fun addHeader(key: String, value: String): CrmAuthorizationRequestBuilder = apply { headers[key] = value }

  fun addRequestBody(
    login: String,
    password: String,
    captcha: String,
    remember: Boolean
  ): CrmAuthorizationRequestBuilder = apply {
    val crmAuthorizationRequest = CrmAuthorizationRequest(
      login = login,
      password = password,
      captcha = captcha,
      remember = remember
    )
    body = mapper.writeValueAsString(crmAuthorizationRequest).toRequestBody()
  }
}