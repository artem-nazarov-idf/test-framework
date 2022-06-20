package config.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import config.model.Access

class AccessProvider {

  fun getAccessData(fileNameProperties : String): Access {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules()
    return mapper.readValue(FileProvider().getFile(fileNameProperties))
  }
}