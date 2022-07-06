package com.framework.test.http.client

import com.framework.test.model.ApplicationConfig
import okhttp3.Request
import okhttp3.RequestBody

class HttpRequestBuilder(
  applicationConfig: ApplicationConfig,
  private val requestBuilder: Request.Builder = Request.Builder()
) {
  private var urlBuilder: HttpUrlBuilder = HttpUrlBuilder(applicationConfig)

  fun get() = apply { requestBuilder.get() }
  fun post(body: RequestBody) = apply { requestBuilder.post(body) }
  fun delete(body: RequestBody?) = apply { requestBuilder.delete(body) }

  fun addAllRequestOptions(
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

  fun addParameters(queryParameters: Map<String, Any>) = apply { urlBuilder.addParameters(queryParameters) }
  fun addEndpoint(endpoint: String) = apply { urlBuilder.addEndpoint(endpoint) }
  fun addHeaders(headers: Map<String, String>): HttpRequestBuilder = apply {
    headers.forEach { (key, value) -> requestBuilder.addHeader(key, value) }
  }

  fun addCookie(cookie: Map<String, String>?) = apply {
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