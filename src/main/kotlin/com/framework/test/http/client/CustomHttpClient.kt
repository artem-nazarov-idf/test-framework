package com.framework.test.http.client

import com.framework.test.context.applicationConfig
import okhttp3.RequestBody
import okhttp3.Response

class CustomHttpClient(
  private val baseUrl: String = applicationConfig().host!!
) : HttpClient {

  private val client = HttpClientBuilder().buildDefaultClient()

  override fun get(
    endpoint: String,
    params: Map<String, Any>,
    headers: Map<String, String>,
    cookies: Map<String, String>?
  ): Response {
    val request = HttpRequestBuilder(baseUrl)
      .addListedParametersToRequest(endpoint, params, headers, cookies)
      .get()
      .build()
    return client.newCall(request).execute()
  }

  override fun post(
    endpoint: String,
    headers: Map<String, String>,
    requestBody: RequestBody,
    cookies: Map<String, String>?,
    params: Map<String, Any>,
  ): Response {
    val request = HttpRequestBuilder(baseUrl)
      .addListedParametersToRequest(endpoint, params, headers, cookies)
      .post(requestBody)
      .build()
    return client.newCall(request).execute()
  }

  override fun delete(
    endpoint: String,
    headers: Map<String, String>,
    requestBody: RequestBody?,
    cookies: Map<String, String>?,
    params: Map<String, Any>,
  ): Response {
    val request = HttpRequestBuilder(baseUrl)
      .addListedParametersToRequest(endpoint, params, headers, cookies)
      .delete(requestBody)
      .build()
    return client.newCall(request).execute()
  }
}