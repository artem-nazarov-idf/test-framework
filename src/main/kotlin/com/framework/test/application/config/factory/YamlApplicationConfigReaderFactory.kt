package com.framework.test.application.config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import com.framework.test.model.ApplicationConfig
import java.io.File

class YamlApplicationConfigReaderFactory(
  private val fileProvider: FileProvider = FileProvider()
) : ApplicationConfigReader {
  override val configFilePath: String = "authData/${FileNames.BASIC_AUTH_FILE_NAME.value}.yaml"
  private val file: File by lazy { fileProvider.getFileFromPath(configFilePath) }

  override fun getApplicationConfigFromFile(): ApplicationConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }
}

