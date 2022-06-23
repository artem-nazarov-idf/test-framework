package com.framework.test.config.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.constants.FileNames
import com.framework.test.constants.FileType

class ApplicationConfigFromYaml() : ConfigFromFile {
  override val fileName  = FileNames.BASIC_AUTH_FILE_NAME.value
  override val fileException = FileType.YAML.value
  private val file = getConfigFile()
  override fun getConfigFromFile(): ApplicationConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }
}

