package config.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import config.model.Access

class AccessProvider {
  fun getAccessDataFromJsonOrYaml(fileName: String): Access {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(FileProvider().getFileFromPath(fileName))
  }
}
