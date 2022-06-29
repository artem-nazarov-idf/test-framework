package com.framework.test.config.provider.driver.factory

import com.framework.test.config.provider.applicationConfig.factory.ApplicationConfigReaderFactory
import com.framework.test.config.provider.applicationConfig.factory.JsonApplicationConfigReaderFactory
import com.framework.test.config.provider.applicationConfig.factory.YamlApplicationConfigReaderFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WebDriverFactoryTest {

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
  fun `Make yaml application config reader default`() {
    val applicationConfigFromDefault = ApplicationConfigReaderFactory().getAppConfigReaderFactory()

    Assertions.assertTrue(
      applicationConfigFromDefault is JsonApplicationConfigReaderFactory,
      "config.file.type not is from yaml"
    )
  }
}
