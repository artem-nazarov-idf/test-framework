package com.framework.test.http.converters

import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging

class CookieConverter(private val response: Response) : Logging {
  fun getCookieValueFromResponse(nameCookie: String): String? {
    return getCookiesFromResponse()[nameCookie]
  }

  fun getCookiesFromResponse(): MutableMap<String, String> {
    val cookiesMap: MutableMap<String, String> = mutableMapOf()
    val cookies: String? = response.headers["set-cookie"]
    if (cookies.isNullOrEmpty()) {
      logger.info("no cookies from response")
      return cookiesMap
    }

    val cookiesList: List<String> = cookies.split("; ")

    for (cookie: String in cookiesList) {
      if (cookie.contains('=')) {
        cookiesMap[cookie.substringBefore('=')] = cookie.substringAfter('=')
      } else {
        cookiesMap[cookie] = ""
      }
    }

    return cookiesMap
  }
}