package com.framework.test.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CrmUserInfo(
  val id: Int,
  val localizedRole: String,
  val partnerType: String?,
  val role: String?,
  val roleId: Int,
  val userName: String
)