package com.framework.test.config.provider.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.config.provider.fileOperations.ConfigFromFile
import com.framework.test.config.provider.fileOperations.FileProvider

class JsonApplicationConfigReaderFactory : ConfigFromFile {
  private val file = FileProvider("authData/basicAuthProperties.json").getFileFromPath()

  override fun getConfigFromFile(): ApplicationConfig {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(file)
  }
}
