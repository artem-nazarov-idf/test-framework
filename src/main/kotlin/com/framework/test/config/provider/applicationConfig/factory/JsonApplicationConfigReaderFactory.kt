package com.framework.test.config.provider.applicationConfig.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import java.io.File

class JsonApplicationConfigReaderFactory(
  private val fileProvider: FileProvider = FileProvider()
) : ApplicationConfigReader {
  override val configFilePath: String = "authData/${FileNames.BASIC_AUTH_FILE_NAME.value}.json"
  private val file: File by lazy { fileProvider.getFileFromPath(configFilePath) }

  override fun getConfigFromFile(): ApplicationConfig {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(file)
  }
}
