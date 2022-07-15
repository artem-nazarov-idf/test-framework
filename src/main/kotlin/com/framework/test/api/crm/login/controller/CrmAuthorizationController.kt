package com.framework.test.api.crm.login.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.api.crm.login.builder.CrmAuthorizationRequestBuilder
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.http.client.CustomHttpClient
import okhttp3.Response

class CrmAuthorizationController(private val endpoint: String) {
  fun postCrmAuthorisationReturnResponse(
    login: String,
    password: String,
    captcha: String,
    remember: Boolean = false
  ): Response {
    val request: CrmAuthorizationRequestBuilder = CrmAuthorizationRequestBuilder()
      .addHeader("content-type", "application/json;charset=UTF-8")
      .addRequestBody(login, password, captcha, remember)
    return CustomHttpClient().post(endpoint, request.headers, request.body)
  }

  fun postCrmAuthorisation(
    login: String, password: String, captcha: String, baseUrl: String, remember: Boolean = false
  ): CrmUserInfoResponse {
    val request: CrmAuthorizationRequestBuilder = CrmAuthorizationRequestBuilder()
      .addHeader("content-type", "application/json;charset=UTF-8")
      .addRequestBody(login, password, captcha, remember)
    val response: Response = CustomHttpClient(baseUrl).post(endpoint, request.headers, request.body)
    return parseBodyToCrmUserInfoResponse(response)
  }

  private fun parseBodyToCrmUserInfoResponse(response: Response): CrmUserInfoResponse {
    return jacksonObjectMapper().readValue(response.body!!.string())
  }
}