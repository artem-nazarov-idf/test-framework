package com.framework.test.config.provider.factory

import com.framework.test.constants.FileType

class ApplicationConfigReaderFactory() {
  private val defaultFileType: String = System.getProperty("config.file.type") ?: FileType.JSON.value

  fun getAppConfigReaderFactory(fileType: String = defaultFileType): ApplicationConfigReader {
    return when (fileType) {
      FileType.JSON.value -> JsonApplicationConfigReaderFactory()
      FileType.YAML.value -> YamlApplicationConfigReaderFactory()
      else -> {
        throw IllegalArgumentException("fileType is \"$fileType\", allowed only json or yaml")
      }
    }
  }
}