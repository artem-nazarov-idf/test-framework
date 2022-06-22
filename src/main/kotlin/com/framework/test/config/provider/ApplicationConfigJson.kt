package com.framework.test.config.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.ApplicationConfig

class ApplicationConfigJson(private val fileName: String) : ApplicationConfigInterface {
  override fun getApplicationConfig(): ApplicationConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(FileProvider(fileName).getFileFromPath())
  }
}