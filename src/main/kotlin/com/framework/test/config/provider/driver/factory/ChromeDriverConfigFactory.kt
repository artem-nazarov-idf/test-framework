package com.framework.test.config.provider.driver.factory

import com.codeborne.selenide.Configuration
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.framework.test.config.model.DriverConfig
import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverConfigFactory(
  private val fileProvider: FileProvider = FileProvider()
) : DriverConfigReader {
  override val configFilePath: String = "driver/${FileNames.DEFAULT_DRIVER_CONFIG.value}.yaml"
  private val file by lazy { fileProvider.getFileFromPath(configFilePath) }

  override fun getConfigFromFile(): DriverConfig {
    val mapper = ObjectMapper(YAMLFactory()).findAndRegisterModules() // worksWithJsonToo
    return mapper.readValue(file)
  }

  fun setDriverConfig() {
    val driverConfig = getConfigFromFile()
    WebDriverManager.chromedriver().setup()

    Configuration.browser = "chrome"
    Configuration.browserVersion = driverConfig.browserVersion
    Configuration.browserSize = driverConfig.browserSize
  }
}