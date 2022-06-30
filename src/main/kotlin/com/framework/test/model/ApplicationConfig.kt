package com.framework.test.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  @JsonProperty("user")
  var userName: String?,
  @JsonProperty("pass")
  var password: String?,
  var host: String?,
  var crmLoginEndpoint: String?,
  var crmStartEndpoint: String?,
  var crmUsers: CRMUsers?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class CRMUsers(
  @JsonProperty("ADMINISTRATOR")
  var administrator: Administrator?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Administrator(
  var login: String?,
  var password: String?,
  var captcha: String?,
  var role: String?
)
