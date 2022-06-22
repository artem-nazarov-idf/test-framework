package com.framework.test

import com.framework.test.config.provider.ApplicationConfigProvider
import com.framework.test.constants.FileNames
import com.framework.test.constants.FileType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

class ApplicationConfigProviderTest {
  @ParameterizedTest
  @EnumSource(FileType::class)
  fun test(fileType: FileType) {
    System.setProperty("fileExtension", fileType.value)
    val access = ApplicationConfigProvider().getAccessDataFromJsonOrYaml(FileNames.BASIC_AUTH_FILE_PATH.value)

    Assertions.assertEquals("test", access.userName)
    Assertions.assertEquals("pass", access.password)
    Assertions.assertEquals("qa-delivery-solva-kz-release.moneyman.ru", access.host)
  }
}
