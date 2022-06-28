package com.framework.test.config.provider.factory

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigReaderFactoryTest {

  @Test
  fun `ApplicationConfigReaderFactory use yaml file type when provided file type is yaml`() {
    System.setProperty("config.file.type", "yaml")
    val applicationConfigFromYaml = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromYaml is YamlApplicationConfigReaderFactory,
      "config.file.type not is from Yaml"
    )
  }

  @Test
  fun `ApplicationConfigReaderFactory use json file type when provided file type is json`() {
    System.setProperty("config.file.type", "json")
    val actualApplicationConfigFromJson = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      actualApplicationConfigFromJson is JsonApplicationConfigReaderFactory,
      "config.file.type not is from Json"
    )
  }

  @Test
  fun `ApplicationConfigReaderFactory use default file type when file type not provided`() {
    System.clearProperty("config.file.type")
    val actualApplicationConfigFromDefault = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      actualApplicationConfigFromDefault is JsonApplicationConfigReaderFactory,
      "config.file.type not is from Json"
    )
  }

  @Test()
  fun `ApplicationConfigReaderFactory throws exception for not supported file type xml`() {
    System.setProperty("config.file.type", "xml")

    val illegalArgumentException: IllegalArgumentException = Assertions.assertThrows(
      IllegalArgumentException::class.java
    ) { ApplicationConfigReaderFactory().getAppConfigReaderFactory() }

    Assertions.assertEquals("fileType is [xml], allowed only json or yaml", illegalArgumentException.message)
  }
}
