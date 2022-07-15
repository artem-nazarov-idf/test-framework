package com.framework.test.model.config

import com.framework.test.constants.BrowserType
import com.framework.test.constants.DriverType

data class DriverConfig(
  var browser: BrowserType,
  var driverType: DriverType,
  var browserSize: String,
  val gridNodIdName: String,
  val webdriverPort: String,
  val localhost: String
)