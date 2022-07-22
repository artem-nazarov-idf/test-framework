package com.framework.test.api.crm.login.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.api.crm.login.builder.CrmAuthorizationRequestBuilder
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.constants.HttpContentType
import com.framework.test.context.applicationConfig
import com.framework.test.http.client.CustomHttpClient
import com.framework.test.model.config.CrmUser
import okhttp3.Response

class CrmAuthorizationController(private val httpClient: CustomHttpClient = CustomHttpClient()) {
  private val endpoint: String = applicationConfig().apiCrmSingInEndpoint!!

  private fun getResponseFromCrmAuthorization(
    crmUser: CrmUser,
  ): Response {
    val request: CrmAuthorizationRequestBuilder = CrmAuthorizationRequestBuilder()
      .addHeader("content-type", HttpContentType.APPLICATION_JSON.value)
      .addRequestBody(crmUser.login!!, crmUser.password!!, crmUser.captcha!!)
    return httpClient.post(endpoint, request.headers, request.body)
  }

  fun postCrmAuthorization(crmUser: CrmUser): CrmUserInfoResponse {
    val response: Response = getResponseFromCrmAuthorization(crmUser)
    return parseBodyToCrmUserInfoResponse(response)
  }

  private fun parseBodyToCrmUserInfoResponse(response: Response): CrmUserInfoResponse {
    return response.body?.let {
      jacksonObjectMapper().readValue(it.string())
    } ?: error("Failed to parse response body. Content is null")
  }
}