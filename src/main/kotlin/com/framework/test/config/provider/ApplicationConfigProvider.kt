package com.framework.test.config.provider

import com.framework.test.constants.FileType

class ApplicationConfigProvider(fileName: String, private val fileType: FileType) {
  private val file = FileProvider(fileName).getFileFromPath()
  fun makeApplicationConfig(): ApplicationConfigInterface {
    return when (fileType) {
      FileType.JSON -> ApplicationConfigJson(file)
      FileType.YAML -> ApplicationConfigYaml(file)

    }
  }
}