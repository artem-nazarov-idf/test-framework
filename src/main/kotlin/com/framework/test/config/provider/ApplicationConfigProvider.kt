package com.framework.test.config.provider

import com.framework.test.constants.FileType

class ApplicationConfigProvider(private val fileType: FileType) {

  fun makeApplicationConfig(): ConfigByFile {
    return when (fileType) {
      FileType.JSON -> ApplicationConfigFromJson()
      FileType.YAML -> ApplicationConfigFromYaml()

    }
  }
}