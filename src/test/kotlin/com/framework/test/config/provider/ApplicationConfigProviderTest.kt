package com.framework.test.config.provider

import com.framework.test.constants.FileType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigProviderTest {
  private val applicationConfig = ApplicationConfigProvider()

  @Test
  fun makeApplicationConfigFromYaml() {
    val applicationConfigFromYaml = applicationConfig.makeApplicationConfig(FileType.YAML)

    Assertions.assertTrue(applicationConfigFromYaml is ApplicationConfigFromYaml, "applicationConfig not is from Yaml")
  }

  @Test
  fun makeApplicationConfigFromJson() {
    val applicationConfigFromJson = applicationConfig.makeApplicationConfig(FileType.JSON)

    Assertions.assertTrue(applicationConfigFromJson is ApplicationConfigFromJson, "applicationConfig not is from Json")
  }

  @Test
  fun makeApplicationConfigFromDefault() {
    val applicationConfigFromDefault = applicationConfig.makeApplicationConfig()

    Assertions.assertTrue(
      applicationConfigFromDefault is ApplicationConfigFromJson,
      "applicationConfig not is from Json"
    )
  }
}
