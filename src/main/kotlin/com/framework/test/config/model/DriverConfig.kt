package com.framework.test.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DriverConfig(
  var browser: String,
  var browserVersion: String,
  var browserSize: String
)
