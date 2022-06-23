package com.framework.test.config.provider

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigFromJsonTest {
  @Test
  fun getApplicationConfigByFileJson() {
    val applicationConfig = ApplicationConfigFromJson().getConfigFromFile()

    Assertions.assertEquals("testJson", applicationConfig.userName)
    Assertions.assertEquals("passJson", applicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruJson", applicationConfig.host)
  }

  @Test
  fun getFileByNameJson() {
    val file = ApplicationConfigFromJson().getConfigFile()

    Assertions.assertEquals("basicAuthProperties.json", file.name)
  }
}