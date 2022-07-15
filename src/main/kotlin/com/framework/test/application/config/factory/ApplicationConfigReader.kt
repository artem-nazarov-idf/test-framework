package com.framework.test.application.config.factory

import com.framework.test.model.config.ApplicationConfig

interface ApplicationConfigReader {
  val configFilePath: String

  fun getApplicationConfigFromFile(): ApplicationConfig
}