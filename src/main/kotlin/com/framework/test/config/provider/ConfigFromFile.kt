package com.framework.test.config.provider

import com.framework.test.config.model.ApplicationConfig
import java.io.File

interface ConfigFromFile {
  val fileName: String
  val fileException: String
  fun getConfigFromFile(): ApplicationConfig
  fun getConfigFile(): File {
    return FileProvider(fileName, fileException).getFileFromPath()
  }
}