package com.framework.test.config.provider

import com.framework.test.config.model.ApplicationConfig

interface ApplicationConfigInterface {
  fun getConfigByFile(): ApplicationConfig
}