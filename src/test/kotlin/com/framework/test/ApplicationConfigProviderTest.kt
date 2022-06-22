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
    val applicationConfig = ApplicationConfigProvider(FileType.YAML).makeApplicationConfig()

    Assertions.assertTrue(applicationConfig is ApplicationConfigFromYaml, "applicationConfig not is from Yaml")
  }
  @Test
  fun makeApplicationConfigFromJson() {
    val applicationConfig = ApplicationConfigProvider(FileType.JSON).makeApplicationConfig()

    Assertions.assertTrue(applicationConfig is ApplicationConfigFromJson, "applicationConfig not is from Json")
  }
}
