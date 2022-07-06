package com.framework.test.http.client

import com.framework.test.model.ApplicationConfig
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

class HttpUrlBuilder(
  applicationConfig: ApplicationConfig
) {
  private val baseUrl = "https://${applicationConfig.host}"
  private val endpoints: MutableList<String> = mutableListOf()
  private val queryParameters: MutableMap<String, Any> = mutableMapOf()

  fun build(): HttpUrl {
    val builder = baseUrl.toHttpUrl().newBuilder()
    endpoints.forEach { endpoint -> builder.addPathSegments(endpoint.removePrefix("/")) }
    queryParameters.forEach { (key, value) -> builder.addQueryParameter(key, value.toString()) }
    return builder.build()
  }

  fun addEndpoint(endpoint: String) = apply { endpoints.add(endpoint) }
  fun addParameters(parameters: Map<String, Any>) = apply { queryParameters.putAll(parameters) }
}