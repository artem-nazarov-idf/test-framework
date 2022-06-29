package com.framework.test.config.provider.applicationConfig.factory

import com.framework.test.constants.FileType

class ApplicationConfigReaderFactory {
  private val defaultFileType: FileType by lazy {
    System.getProperty("config.file.type")?.let { FileType.from(it) } ?: FileType.YAML
  }

  fun getAppConfigReaderFactory(fileType: FileType = defaultFileType): ApplicationConfigReader {
    return when (fileType) {
      FileType.JSON -> JsonApplicationConfigReaderFactory()
      FileType.YAML -> YamlApplicationConfigReaderFactory()
    }
  }
}