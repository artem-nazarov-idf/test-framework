package com.framework.test.constants

enum class FileType(val value: String) {
  YAML("yaml"), JSON("json");

  companion object {
    fun from(search: String): FileType? = values().find { it.value == search }
  }
}