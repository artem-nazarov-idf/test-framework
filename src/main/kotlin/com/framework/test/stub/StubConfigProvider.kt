package com.framework.test.stub

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import com.framework.test.model.config.StubConfig
import java.io.File

class StubConfigProvider {
  private val configFilePath: String = "stub/config/${FileNames.DEFAULT_STUB_CONFIG.value}.yaml"
  private val file: File by lazy { FileProvider().getFileFromPath(configFilePath) }

  fun getStubConfigFromFile(): StubConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules()
    return mapper.readValue(file)
  }
}