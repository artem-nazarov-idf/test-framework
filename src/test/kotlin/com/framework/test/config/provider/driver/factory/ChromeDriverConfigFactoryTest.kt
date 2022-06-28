package com.framework.test.config.provider.driver.factory

import com.framework.test.constants.FileNames
import com.framework.test.file.reader.FileProvider
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.io.File

@ExtendWith(MockKExtension::class)
class ChromeDriverConfigFactoryTest {
  @MockK
  lateinit var fileProvider: FileProvider

  @Test
  fun `Get chrome driver config by file`() {
    val configFilePath = "driver/${FileNames.DEFAULT_DRIVER_CONFIG.value}.yaml"

    every { fileProvider.getFileFromPath(configFilePath) } returns File(
      this.javaClass.classLoader.getResource(configFilePath)?.path.toString()
    )

    val driverConfig = ChromeDriverConfigFactory(fileProvider).getConfigFromFile()

    Assertions.assertEquals("chrome", driverConfig.browser)
    Assertions.assertEquals("102", driverConfig.browserVersion)
    Assertions.assertEquals("1920x1080", driverConfig.browserSize)
  }
}