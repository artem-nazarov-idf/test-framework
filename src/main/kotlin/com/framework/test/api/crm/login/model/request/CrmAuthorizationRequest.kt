package com.framework.test.api.crm.login.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CrmAuthorizationRequest(
  val login: String,
  val password: String,
  val captcha: String,
  val remember: Boolean
)