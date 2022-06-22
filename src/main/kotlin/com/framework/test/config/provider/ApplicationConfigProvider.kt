package com.framework.test.config.provider

import com.framework.test.constants.FileType

class ApplicationConfigProvider(private val fileName: String, private val fileType: FileType) {

  fun makeApplicationConfig(): ApplicationConfigInterface {
    return when (fileType) {
      FileType.JSON -> ApplicationConfigJson(fileName)
      FileType.YAML -> ApplicationConfigYaml(fileName)

    }
  }
}