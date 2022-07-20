package com.framework.test.api.crm.login.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.api.crm.login.builder.CrmAuthorizationRequestBuilder
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.constants.EndPoints
import com.framework.test.constants.HttpContentType
import com.framework.test.context.sessionContext
import com.framework.test.http.client.CustomHttpClient
import com.framework.test.http.converters.CookieConverter
import com.framework.test.model.config.CrmUser
import okhttp3.Response

class CrmAuthorizationController() {
  private val endpoint: String = EndPoints.CRM_SIGN_IN
  private val httpClient = CustomHttpClient()

  private fun postCrmAuthorisationReturnResponse(
    crmUser: CrmUser,
    remember: Boolean = false
  ): Response {
    val request: CrmAuthorizationRequestBuilder = CrmAuthorizationRequestBuilder()
      .addHeader("content-type", HttpContentType.APPLICATION_JSON.value)
      .addRequestBody(crmUser.login!!, crmUser.password!!, crmUser.captcha!!, remember)
    return httpClient.post(endpoint, request.headers, request.body)
  }

  fun postCrmAuthorisation(crmUser: CrmUser): CrmUserInfoResponse {
    val response: Response = postCrmAuthorisationReturnResponse(crmUser)
    sessionContext().responseCookies = CookieConverter(response).getCookiesFromResponse() // интерсептор по кукам
    // если надо везде.
    return parseBodyToCrmUserInfoResponse(response)
  }

  private fun parseBodyToCrmUserInfoResponse(response: Response): CrmUserInfoResponse {
    return response.body?.let {
      jacksonObjectMapper().readValue(it.string())
    } ?: error("Failed to parse response body. Content is null")
  }
}