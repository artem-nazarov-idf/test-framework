package com.framework.test.model.config

import com.fasterxml.jackson.annotation.JsonProperty

data class ApplicationConfig(
  @JsonProperty("user")
  var userName: String?,
  @JsonProperty("pass")
  var password: String?,
  var host: String?,
  var crmLoginEndpoint: String?,
  var crmStartEndpoint: String?,
  var crmUsers: CRMUsers?,
  var stub: StubConfig
) {
  fun getBaseUrl(): String {
    return "https://$host"
  }
}

data class CRMUsers(
  @JsonProperty("ADMINISTRATOR")
  var administrator: CrmUser,
  @JsonProperty("TERMINATOR")
  var terminator: CrmUser
)

data class CrmUser(
  var login: String?,
  var password: String?,
  var captcha: String?,
  var role: String?
)

data class StubConfig(
  var host: String,
  var port: Int
)