package com.framework.test.config.provider.applicationConfig.factory

import com.framework.test.model.ApplicationConfig

interface ApplicationConfigReader {
  val configFilePath: String

  fun getApplicationConfigFromFile(): ApplicationConfig
}