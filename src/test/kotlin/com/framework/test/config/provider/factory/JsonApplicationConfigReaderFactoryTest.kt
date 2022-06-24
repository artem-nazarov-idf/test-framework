package com.framework.test.config.provider.factory

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class JsonApplicationConfigReaderFactoryTest {
  @Test
  fun getApplicationConfigByFileJson() {
    val applicationConfig = JsonApplicationConfigReaderFactory().getConfigFromFile()

    Assertions.assertEquals("testJson", applicationConfig.userName)
    Assertions.assertEquals("passJson", applicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruJson", applicationConfig.host)
  }
}