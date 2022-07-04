package com.framework.test.api

import com.framework.test.http.client.CustomHttpClient
import okhttp3.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Testom {
  val url: String = "https://publicobject.com/helloworld.txt"

  @Test
  fun test() {
    val response: Response = CustomHttpClient().get(url)

    Assertions.assertEquals(200, response.code)
    Assertions.assertEquals(200, response.code)
  }
}