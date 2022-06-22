package com.framework.test.config.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.constants.FileNames
import java.io.File

class ApplicationConfigFromJson() : ConfigByFile {
  private val file = getFileByName(FileNames.BASIC_AUTH_FILE_NAME.value)
  override fun getConfigByFile(): ApplicationConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }
  override fun getFileByName(fileName: String): File {
    return FileProvider(fileName).getFileFromPath()
  }
}
