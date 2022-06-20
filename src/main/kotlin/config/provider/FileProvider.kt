package config.provider

import java.io.File
import java.net.URL

class FileProvider {
  fun getFile(nameFile : String): File {
    val resource: URL? = this.javaClass.classLoader.getResource(nameFile)
    return File(resource?.path.toString())
  }
}