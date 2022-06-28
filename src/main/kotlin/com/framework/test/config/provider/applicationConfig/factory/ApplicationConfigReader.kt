package com.framework.test.config.provider.applicationConfig.factory

import com.framework.test.config.model.ApplicationConfig

interface ApplicationConfigReader {
  val configFilePath: String

  fun getConfigFromFile(): ApplicationConfig
}