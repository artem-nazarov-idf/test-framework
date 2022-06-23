package com.framework.test

import com.framework.test.config.provider.ApplicationConfigFromYaml
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigFromYamlTest {
  @Test
  fun getApplicationConfigByFileYaml() {
    val applicationConfig = ApplicationConfigFromYaml().getConfigFromFile()

    Assertions.assertEquals("testYaml", applicationConfig.userName)
    Assertions.assertEquals("passYaml", applicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruYaml", applicationConfig.host)
  }

  @Test
  fun getFileByNameYaml() {
    val file = ApplicationConfigFromYaml().getConfigFile()

    Assertions.assertEquals("basicAuthProperties.yaml", file.name)
  }
}