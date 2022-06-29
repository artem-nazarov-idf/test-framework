package com.framework.test.file.reader

import java.io.File
import java.net.URL

class FileProvider {
  fun getFileFromPath(pathFromSourceRoot: String): File {
    val resource: URL? = this.javaClass.classLoader.getResource(pathFromSourceRoot)
    return File(resource?.path.toString())
  }
}
