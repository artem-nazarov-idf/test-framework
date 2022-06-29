package com.framework.test.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Administrator(
  var login: String,
  var password: String,
  var captcha: String,
  var role: String
)
