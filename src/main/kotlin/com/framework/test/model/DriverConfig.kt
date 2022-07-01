package com.framework.test.model

data class DriverConfig(
  var browser: String,
  var browserSize: String,
  val gridNodIdName: String,
  val webdriverPort: String,
  val webdriverHost: String
)
