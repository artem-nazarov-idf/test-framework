package com.framework.test

import com.framework.test.config.provider.ApplicationConfigProvider
import com.framework.test.constants.FileNames
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ApplicationConfigProviderTest {
  @ParameterizedTest
  @ValueSource(strings = ["json", "yaml"])
  fun test(fileExtension: String) {
    System.setProperty("fileExtension", fileExtension)
    val access = ApplicationConfigProvider().getAccessDataFromJsonOrYaml(FileNames.BASIC_AUTH_FILE_PATH.value)

    Assertions.assertEquals("test", access.userName)
    Assertions.assertEquals("pass", access.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ru", access.host)
  }
}
