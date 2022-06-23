package com.framework.test

import com.framework.test.config.provider.ApplicationConfigFromJson
import com.framework.test.config.provider.ApplicationConfigFromYaml
import com.framework.test.config.provider.ApplicationConfigProvider
import com.framework.test.constants.FileType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigProviderTest {
  @Test
  fun makeApplicationConfigFromYaml() {
    val applicationConfig = ApplicationConfigProvider().makeApplicationConfig(FileType.YAML)

    Assertions.assertTrue(applicationConfig is ApplicationConfigFromYaml, "applicationConfig not is from Yaml")
  }
  @Test
  fun makeApplicationConfigFromJson() {
    val applicationConfig = ApplicationConfigProvider().makeApplicationConfig(FileType.JSON)

    Assertions.assertTrue(applicationConfig is ApplicationConfigFromJson, "applicationConfig not is from Json")
  }
  @Test
  fun makeApplicationConfigFromDefault() {
    val applicationConfig = ApplicationConfigProvider().makeApplicationConfig()

    Assertions.assertTrue(applicationConfig is ApplicationConfigFromJson, "applicationConfig not is from Json")
  }
}
