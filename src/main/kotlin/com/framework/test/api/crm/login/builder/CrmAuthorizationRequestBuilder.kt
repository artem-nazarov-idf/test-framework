package com.framework.test.api.crm.login.builder

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.framework.test.api.crm.login.model.request.CrmAuthorizationRequest
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class CrmAuthorizationRequestBuilder {
  private val mapper = jacksonObjectMapper()

  fun buildRequestBody(login: String, password: String, captcha: String, remember: Boolean): RequestBody {
    val crmAuthorizationRequest = CrmAuthorizationRequest(
      login = login,
      password = password,
      captcha = captcha,
      remember = remember
    )

    return mapper.writeValueAsString(crmAuthorizationRequest).toRequestBody()
  }
}