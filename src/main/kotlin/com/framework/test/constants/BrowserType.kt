package com.framework.test.constants

enum class BrowserType(val value: String) {
  CHROME("chrome"), FIREFOX("firefox");

  companion object {
    fun from(search: String): BrowserType? = values().find { it.value == search }
  }
}