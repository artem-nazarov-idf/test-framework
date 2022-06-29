package com.framework.test.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  @JsonProperty("user")
  var userName: String,
  @JsonProperty("pass")
  var password: String,
  var host: String,
  var crmLoginEndpoint: String,
  var crmStartEndpoint: String,
  var crmUsers: CRMUsers
)
