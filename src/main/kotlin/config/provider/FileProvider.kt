package config.provider

import java.io.File
import java.net.URL

class FileProvider {
  fun getFile(nameFile : String): File {
    val fileExtension = System.getProperty("fileExtension")
    val resource: URL? = this.javaClass.classLoader.getResource("$nameFile.$fileExtension")
    return File(resource?.path.toString())
  }
}