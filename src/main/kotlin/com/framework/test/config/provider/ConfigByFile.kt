package com.framework.test.config.provider

import com.framework.test.config.model.ApplicationConfig
import java.io.File

interface ConfigByFile {
  fun getConfigByFile(): ApplicationConfig
  fun getFileByName(fileName: String): File
}