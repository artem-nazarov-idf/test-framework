package com.framework.test

import com.framework.test.config.provider.FileProvider
import com.framework.test.constants.FileNames
import com.framework.test.constants.FileType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class FileProviderTest {
  @ParameterizedTest
  @EnumSource(FileType::class)
  fun test(fileType: FileType) {
    val fileName = FileNames.BASIC_AUTH_FILE_NAME.value
    System.setProperty("fileExtension", fileType.value)
    val file = FileProvider(fileName).getFileFromPath()

    Assertions.assertEquals("$fileName.${fileType.value}", file.name)
  }
}