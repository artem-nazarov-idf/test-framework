package com.framework.test.http.converters

import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging

class CookieConverter : Logging {
  fun getCookieValueFromResponse(response: Response, nameCookie: String): String {
    val cookies: String? = response.headers["set-cookie"]
    if (cookies.isNullOrEmpty()) {
      logger.info("no cookies from response")
      return ""
    }

    val value = cookies.substringAfter(nameCookie).substringBefore(";")

    return if (value == "") {
      logger.info("no value from cookie [$nameCookie]")
      ""
    } else {
      value.substringAfter("=")
    }
  }
}