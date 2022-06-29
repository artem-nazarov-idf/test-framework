package com.framework.test.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
data class DriverConfig(
  var browser: String?,
  var browserVersion: String?,
  var browserSize: String?
)
