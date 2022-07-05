package com.framework.test.api

import com.framework.test.http.client.CustomHttpClient
import okhttp3.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Testom {
  private val url: String = "https://qa-delivery-solva-kz-release.moneyman.ru" // TODO: 04.07.2022 убрать хардкод

  @Test
  fun test() {
    val response: Response = CustomHttpClient().get(url)

//    Assertions.assertEquals(200, response.code)
    Assertions.assertEquals("123", response.body!!.string())
  }
}