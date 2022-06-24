package com.framework.test.config.provider.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.config.provider.fileOperations.ConfigFromFile
import com.framework.test.config.provider.fileOperations.FileProvider

class YamlApplicationConfigReaderFactory() : ConfigFromFile {
  private val file = FileProvider("authData/basicAuthProperties.yaml").getFileFromPath()

  override fun getConfigFromFile(): ApplicationConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }
}

