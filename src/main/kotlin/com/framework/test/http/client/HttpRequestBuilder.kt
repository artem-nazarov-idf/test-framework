package com.framework.test.http.client

import okhttp3.Request
import okhttp3.RequestBody

class HttpRequestBuilder(
  baseUrl: String,
  private val requestBuilder: Request.Builder = Request.Builder()
) {
  private var urlBuilder: HttpUrlBuilder = HttpUrlBuilder(baseUrl)

  fun get() = apply { requestBuilder.get() }
  fun post(body: RequestBody) = apply { requestBuilder.post(body) }
  fun delete(body: RequestBody?) = apply { requestBuilder.delete(body) }

  fun addListedParametersToRequest(
    endpoint: String,
    params: Map<String, Any>,
    headers: Map<String, String>,
    cookies: Map<String, String>?
  ): HttpRequestBuilder {
    return this
      .addEndpoint(endpoint)
      .addParameters(params)
      .addHeaders(headers)
      .addCookie(cookies)
  }

  private fun addParameters(queryParameters: Map<String, Any>) = apply { urlBuilder.addParameters(queryParameters) }
  private fun addEndpoint(endpoint: String) = apply { urlBuilder.addEndpoint(endpoint) }
  private fun addHeaders(headers: Map<String, String>): HttpRequestBuilder = apply {
    headers.forEach { (key, value) -> requestBuilder.addHeader(key, value) }
  }

  private fun addCookie(cookie: Map<String, String>?) = apply {
    if (!cookie.isNullOrEmpty()) {
      val cookieString = cookie.map { cookie -> "${cookie.key}=${cookie.value}" }
        .joinToString(separator = ";", postfix = ";")
      requestBuilder.addHeader("Cookie", cookieString)
    }
  }

  fun build(): Request {
    return requestBuilder.url(urlBuilder.build()).build()
  }
}