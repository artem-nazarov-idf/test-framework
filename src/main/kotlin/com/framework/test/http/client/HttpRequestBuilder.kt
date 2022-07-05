package com.framework.test.http.client

import okhttp3.Request

class HttpRequestBuilder(
  private val requestBuilder: Request.Builder = Request.Builder()
) {

  fun addHeaders(headers: Map<String, String>): HttpRequestBuilder = apply {
    headers.forEach { (key, value) -> requestBuilder.addHeader(key, value) }
  }

  fun url(url: String): HttpRequestBuilder {
    return apply { requestBuilder.url(url) }
  }

  fun build(): Request {
    return requestBuilder.build()
  }
}