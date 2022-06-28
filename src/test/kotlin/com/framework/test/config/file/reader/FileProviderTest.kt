package com.framework.test.config.file.reader

import com.framework.test.file.reader.FileProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class FileProviderTest {
  @ParameterizedTest
  @ValueSource(strings = ["authData/basicAuthProperties.json", "authData/basicAuthProperties.yaml"])
  fun test(pathFromSourceRoot: String) {
    val file = FileProvider().getFileFromPath(pathFromSourceRoot)

    Assertions.assertEquals(pathFromSourceRoot, "${file.parentFile.name}/${file.name}")
  }
}