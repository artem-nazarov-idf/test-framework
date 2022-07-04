package com.framework.test.model

import com.framework.test.constants.BrowserType

data class DriverConfig(
  var browser: BrowserType,
  var browserSize: String,
  val gridNodIdName: String,
  val webdriverPort: String,
  val localhost: String
)
