package com.framework.test.http.client

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

class HttpUrlBuilder(
  private val baseUrl: String
) {
  private val endpoints: MutableList<String> = mutableListOf()
  private val queryParameters: MutableMap<String, Any> = mutableMapOf()

  fun build(): HttpUrl {
    val builder = getHttpsUrl().toHttpUrl().newBuilder()
    endpoints.forEach { endpoint -> builder.addPathSegments(endpoint.removePrefix("/")) }
    queryParameters.forEach { (key, value) -> builder.addQueryParameter(key, value.toString()) }
    return builder.build()
  }

  private fun getHttpsUrl(): String {
    return if (baseUrl.startsWith("http")) {
      baseUrl
    } else {
      "https://$baseUrl"
    }
  }

  fun addEndpoint(endpoint: String) = apply { endpoints.add(endpoint) }
  fun addParameters(parameters: Map<String, Any>) = apply { queryParameters.putAll(parameters) }
}