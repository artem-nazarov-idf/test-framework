package com.framework.test.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ApplicationConfig(
  @JsonProperty("user")
  var userName: String?,
  @JsonProperty("pass")
  var password: String?,
  var host: String?,
  var crmLoginEndpoint: String?,
  var crmStartEndpoint: String?,
  var crmUsers: CRMUsers?
) {
  fun getBaseUrl(): String {
    return "https://$host"
  }
}

data class CRMUsers(
  @JsonProperty("ADMINISTRATOR")
  var administrator: Administrator
)

data class Administrator(
  var login: String?,
  var password: String?,
  var captcha: String?,
  var role: String?
)
