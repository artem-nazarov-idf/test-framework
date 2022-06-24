package com.framework.test.config.provider.factory

import com.framework.test.constants.FileType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApplicationConfigReaderFactoryTest {
  private lateinit var applicationConfig: ApplicationConfigReaderFactory

  @BeforeEach
  fun initialiseApplicationConfigProvider() {
    applicationConfig = ApplicationConfigReaderFactory()
  }

  @Test
  fun makeApplicationConfigFromYaml() {
    val applicationConfigFromYaml = applicationConfig.getAppConfigReaderFactory(FileType.YAML)

    Assertions.assertTrue(
      applicationConfigFromYaml is YamlApplicationConfigReaderFactory,
      "applicationConfig not is from Yaml"
    )
  }

  @Test
  fun makeApplicationConfigFromJson() {
    val applicationConfigFromJson = applicationConfig.getAppConfigReaderFactory(FileType.JSON)

    Assertions.assertTrue(
      applicationConfigFromJson is JsonApplicationConfigReaderFactory,
      "applicationConfig not is from Json"
    )
  }

  @Test
  fun makeApplicationConfigFromDefault() {
    val applicationConfigFromDefault = applicationConfig.getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromDefault is JsonApplicationConfigReaderFactory,
      "applicationConfig not is from Json"
    )
  }
}
