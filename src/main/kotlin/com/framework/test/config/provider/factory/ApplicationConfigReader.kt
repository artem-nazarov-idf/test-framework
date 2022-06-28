package com.framework.test.config.provider.factory

import com.framework.test.config.model.ApplicationConfig

interface ApplicationConfigReader {
  val configFilePath: String

  fun getConfigFromFile(): ApplicationConfig
}