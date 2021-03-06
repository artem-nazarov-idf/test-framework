package com.framework.test.application.config.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import com.framework.test.model.config.ApplicationConfig
import java.io.File

class JsonApplicationConfigReaderFactory(
  private val fileProvider: FileProvider = FileProvider()
) : ApplicationConfigReader {
  override val configFilePath: String = "authData/${FileNames.BASIC_AUTH_FILE_NAME.value}.json"
  private val file: File by lazy { fileProvider.getFileFromPath(configFilePath) }

  override fun getApplicationConfigFromFile(): ApplicationConfig {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(file)
  }
}