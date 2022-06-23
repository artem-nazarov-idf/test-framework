package com.framework.test.config.provider

import com.framework.test.constants.FileType

class ApplicationConfigProvider() {

  fun makeApplicationConfig(fileType: FileType = FileType.JSON): ConfigFromFile {
    return when (fileType) {
      FileType.JSON -> ApplicationConfigFromJson()
      FileType.YAML -> ApplicationConfigFromYaml()

    }
  }
}