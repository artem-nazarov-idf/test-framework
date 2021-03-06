package com.framework.test.application.config.factory

import com.framework.test.constants.FileType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigReaderFactoryTest {

  @Test
  fun `ApplicationConfigReaderFactory use yaml file type when provided file type is yaml`() {
    val applicationConfigFromYaml = ApplicationConfigReaderFactory().getAppConfigReaderFactory(FileType.YAML)

    Assertions.assertTrue(
      applicationConfigFromYaml is YamlApplicationConfigReaderFactory,
      "config.file.type not is from Yaml"
    )
  }

  @Test
  fun `ApplicationConfigReaderFactory use json file type when provided file type is json`() {
    val actualApplicationConfigFromJson = ApplicationConfigReaderFactory().getAppConfigReaderFactory(FileType.JSON)

    Assertions.assertTrue(
      actualApplicationConfigFromJson is JsonApplicationConfigReaderFactory,
      "config.file.type not is from Json"
    )
  }

  @Test
  fun `ApplicationConfigReaderFactory use default file type when file type not provided`() {
    val actualApplicationConfigFromDefault = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      actualApplicationConfigFromDefault is YamlApplicationConfigReaderFactory,
      "config.file.type not is from Yaml"
    )
  }

  @Test
  fun `ApplicationConfigReaderFactory use json file type when provided file type is json from System property`() {
    System.setProperty("config.file.type", "json")
    val applicationConfigFromYaml = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromYaml is JsonApplicationConfigReaderFactory,
      "config.file.type not is from json"
    )

    System.clearProperty("config.file.type")
  }
}