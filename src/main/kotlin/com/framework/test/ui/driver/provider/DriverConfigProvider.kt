package com.framework.test.ui.driver.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import com.framework.test.model.DriverConfig
import java.io.File

class DriverConfigProvider {
  private val configFilePath: String = "driver/${FileNames.DEFAULT_DRIVER_CONFIG.value}.yaml"
  private val file: File by lazy { FileProvider().getFileFromPath(configFilePath) }

  fun getDriverConfigFromFile(): DriverConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }
}