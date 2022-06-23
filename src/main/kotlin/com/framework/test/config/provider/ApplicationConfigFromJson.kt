package com.framework.test.config.provider

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.constants.FileNames
import com.framework.test.constants.FileType

class ApplicationConfigFromJson() : ConfigFromFile {
  override val fileName = FileNames.BASIC_AUTH_FILE_NAME.value
  override val fileException = FileType.JSON.value
  private val file = getConfigFile()
  override fun getConfigFromFile(): ApplicationConfig {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(file)
  }
}
