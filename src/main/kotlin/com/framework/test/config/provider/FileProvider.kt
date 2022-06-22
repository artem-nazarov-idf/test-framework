package com.framework.test.config.provider

import java.io.File
import java.net.URL

class FileProvider(private  val nameFile : String, private val fileExtension : String) {
  fun getFileFromPath(): File {
    val resource: URL? = this.javaClass.classLoader.getResource("authData/$nameFile.$fileExtension")
    return File(resource?.path.toString())
  }
}
