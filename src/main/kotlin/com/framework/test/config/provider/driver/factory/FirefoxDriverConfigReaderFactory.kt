package com.framework.test.config.provider.driver.factory

import com.codeborne.selenide.Configuration
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.DriverConfig
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxDriverConfigReaderFactory(
  private val fileProvider: FileProvider = FileProvider()
) : DriverConfigReader, DriverConfigSetter {
  override val configFilePath: String = "driver/${FileNames.DEFAULT_DRIVER_CONFIG.value}.yaml"
  private val file by lazy { fileProvider.getFileFromPath(configFilePath) }

  override fun getDriverConfigFromFile(): DriverConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }

  override fun setDriverConfig() {
    val driverConfig = getDriverConfigFromFile()
    WebDriverManager.firefoxdriver().setup()

    Configuration.baseUrl = "https://"
    Configuration.browser = "firefox"
    Configuration.browserSize = driverConfig.browserSize
  }
}