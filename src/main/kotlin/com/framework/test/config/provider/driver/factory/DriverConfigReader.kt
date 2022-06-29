package com.framework.test.config.provider.driver.factory

import com.framework.test.config.model.DriverConfig

interface DriverConfigReader {
  val configFilePath: String

  fun getConfigFromFile(): DriverConfig

  fun setDriverConfig()
}