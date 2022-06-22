package com.framework.test

import com.framework.test.config.provider.ApplicationConfigFromJson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigFromJsonTest {
  @Test
  fun getApplicationConfigByFileJson() {
    val applicationConfig = ApplicationConfigFromJson().getConfigByFile()

    Assertions.assertEquals("testJson", applicationConfig.userName)
    Assertions.assertEquals("passJson", applicationConfig.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ruJson", applicationConfig.host)
  }
}