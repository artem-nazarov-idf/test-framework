package com.framework.test.config.provider.fileOperations

import java.io.File
import java.net.URL

class FileProvider(private val pathFromSourceRoot: String) {
  fun getFileFromPath(): File {
    val resource: URL? = this.javaClass.classLoader.getResource(pathFromSourceRoot)
    return File(resource?.path.toString())
  }
}
