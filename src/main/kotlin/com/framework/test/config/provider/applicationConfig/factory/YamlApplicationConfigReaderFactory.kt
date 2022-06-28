package com.framework.test.config.provider.applicationConfig.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider

class YamlApplicationConfigReaderFactory(
  private val fileProvider: FileProvider = FileProvider()
) : ApplicationConfigReader {
  override val configFilePath: String = "authData/${FileNames.BASIC_AUTH_FILE_NAME.value}.yaml"
  private val file by lazy { fileProvider.getFileFromPath(configFilePath) }

  override fun getConfigFromFile(): ApplicationConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }
}

