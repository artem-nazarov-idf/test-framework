package com.framework.test.application.config.factory

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
class JsonApplicationConfigReaderFactoryTest {
  @MockK
  lateinit var fileProvider: FileProvider

  @Test
  fun `JsonApplicationConfigReaderFactory returns ApplicationConfig selected json file`() {
    val configFilePath = "authData/${FileNames.BASIC_AUTH_FILE_NAME.value}.json"

    every { fileProvider.getFileFromPath(configFilePath) } returns File(
      this.javaClass.classLoader.getResource(configFilePath)?.path.toString()
    )

    val actualApplicationConfig = JsonApplicationConfigReaderFactory(fileProvider).getApplicationConfigFromFile()

    Assertions.assertEquals("testJson", actualApplicationConfig.userName)
    Assertions.assertEquals("passJson", actualApplicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruJson", actualApplicationConfig.host)
  }
}