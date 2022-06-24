package com.framework.test.config.provider.factory

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class YamlApplicationConfigReaderFactoryTest {
  @Test
  fun getApplicationConfigByFileYaml() {
    val applicationConfig = YamlApplicationConfigReaderFactory().getConfigFromFile()

    Assertions.assertEquals("testYaml", applicationConfig.userName)
    Assertions.assertEquals("passYaml", applicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruYaml", applicationConfig.host)
  }
}