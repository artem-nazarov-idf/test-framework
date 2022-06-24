package com.framework.test.config.provider.factory

import com.framework.test.config.provider.fileOperations.ConfigFromFile
import com.framework.test.constants.FileType

class ApplicationConfigReaderFactory() {

  fun getAppConfigReaderFactory(fileType: FileType = FileType.JSON): ConfigFromFile {

    return when (fileType) {
      FileType.JSON -> JsonApplicationConfigReaderFactory()
      FileType.YAML -> YamlApplicationConfigReaderFactory()
    }
  }
}