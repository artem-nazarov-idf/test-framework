package com.framework.test.model.config

import com.fasterxml.jackson.annotation.JsonProperty
import com.framework.test.constants.CrmUserRole

data class ApplicationConfig(
  @JsonProperty("user")
  var userName: String?,
  @JsonProperty("pass")
  var password: String?,
  var host: String?,
  var apiCrmSingInEndpoint: String?,
  var crmLoginEndpoint: String?,
  var crmStartEndpoint: String?,
  val crmUsers: Map<CrmUserRole, CrmUser>? = null,
  var stub: StubConfig,
  var dbSqlConfig: DbSqlConfig
) {
  fun getBaseUrl(): String {
    return "https://$host"
  }
}

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

data class DbSqlConfig(
  var url: String,
  var user: String,
  var password: String,
  var mainSchema: String
)