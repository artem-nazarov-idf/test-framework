package com.framework.test.config.provider.applicationConfig.factory

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigReaderFactoryTest {

  @Test
  fun `Make yaml application config reader`() {
    System.setProperty("config.file.type", "yaml")
    val applicationConfigFromYaml = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromYaml is YamlApplicationConfigReaderFactory,
      "config.file.type not is from Yaml"
    )
  }

  @Test
  fun `Make json application config reader`() {
    System.setProperty("config.file.type", "json")
    val applicationConfigFromJson = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromJson is JsonApplicationConfigReaderFactory,
      "config.file.type not is from Json"
    )
  }

  @Test
  fun `Make json application config reader default`() {
    System.clearProperty("config.file.type")
    val applicationConfigFromDefault = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromDefault is JsonApplicationConfigReaderFactory,
      "config.file.type not is from Json"
    )
  }

  @Test()
  fun `Make application config reader error with xml`() {
    System.setProperty("config.file.type", "xml")

    val illegalArgumentException: IllegalArgumentException = Assertions.assertThrows(
      IllegalArgumentException::class.java
    ) { ApplicationConfigReaderFactory().getAppConfigReaderFactory() }

    Assertions.assertEquals("fileType is \"xml\", allowed only json or yaml", illegalArgumentException.message)
  }
}
