package com.framework.test.file.reader

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class FileProviderTest {
  @ParameterizedTest
  @ValueSource(strings = ["authData/basicAuthProperties.json", "authData/basicAuthProperties.yaml"])
  fun gettingFileFromPath(pathFromSourceRoot: String) {
    val actualFile = FileProvider().getFileFromPath(pathFromSourceRoot)

    Assertions.assertEquals(pathFromSourceRoot, "${actualFile.parentFile.name}/${actualFile.name}")
  }
}