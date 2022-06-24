package com.framework.test.config.provider.fileOperations

import com.framework.test.config.model.ApplicationConfig

interface ConfigFromFile {
  fun getConfigFromFile(): ApplicationConfig
}