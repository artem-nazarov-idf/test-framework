package com.framework.test

import com.framework.test.config.provider.ApplicationConfigProvider
import com.framework.test.constants.FileNames
import com.framework.test.constants.FileType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ApplicationConfigProviderTest {
  @ParameterizedTest
  @EnumSource(FileType::class)
  fun test(fileType: FileType) {
    val applicationConfig = ApplicationConfigProvider(FileNames.BASIC_AUTH_FILE_NAME.value, fileType)

  }
}
