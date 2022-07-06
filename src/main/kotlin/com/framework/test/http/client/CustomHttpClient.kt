package com.framework.test.http.client

import com.framework.test.http.interseptors.BasicAuthInterceptor
import com.framework.test.http.interseptors.LoggingInterceptor
import com.framework.test.http.interseptors.SuccessStatusCodeInterceptor
import com.framework.test.model.ApplicationConfig
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Response

class CustomHttpClient(private val applicationConfig: ApplicationConfig) : MakeRequest {

  private val client =
    OkHttpClient.Builder()
      .addInterceptor(BasicAuthInterceptor(applicationConfig.userName!!, applicationConfig.password!!))
      .addInterceptor(LoggingInterceptor())
      .addInterceptor(SuccessStatusCodeInterceptor())
      .build()

  override fun get(
    endpoint: String,
    params: Map<String, Any>,
    headers: Map<String, String>,
    cookies: Map<String, String>?
  ): Response {
    val request = HttpRequestBuilder(applicationConfig)
      .addAllRequestOptions(endpoint, params, headers, cookies)
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
    val request = HttpRequestBuilder(applicationConfig)
      .addAllRequestOptions(endpoint, params, headers, cookies)
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
    val request = HttpRequestBuilder(applicationConfig)
      .addAllRequestOptions(endpoint, params, headers, cookies)
      .delete(requestBody)
      .build()
    return client.newCall(request).execute()
  }
}