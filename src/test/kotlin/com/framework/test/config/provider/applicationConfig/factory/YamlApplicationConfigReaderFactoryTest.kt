package com.framework.test.config.provider.applicationConfig.factory

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
class YamlApplicationConfigReaderFactoryTest {
  @MockK
  lateinit var fileProvider: FileProvider

  @Test
  fun `YamlApplicationConfigReaderFactory returns ApplicationConfig selected yaml file`() {
    val configFilePath = "authData/${FileNames.BASIC_AUTH_FILE_NAME.value}.yaml"

    every { fileProvider.getFileFromPath(configFilePath) } returns File(
      this.javaClass.classLoader.getResource(configFilePath)?.path.toString()
    )

    val actualApplicationConfig = YamlApplicationConfigReaderFactory(fileProvider).getConfigFromFile()

    Assertions.assertEquals("testYaml", actualApplicationConfig.userName)
    Assertions.assertEquals("passYaml", actualApplicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruYaml", actualApplicationConfig.host)
  }
}