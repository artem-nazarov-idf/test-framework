package com.framework.test.http.client

import com.framework.test.http.client.interseptors.BasicAuthInterceptor
import com.framework.test.http.client.interseptors.LoggingInterceptor
import com.framework.test.http.client.interseptors.SuccessStatusCodeInterceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class CustomHttpClient : MakeOperations {
  private val client = OkHttpClient.Builder()
    .addInterceptor(BasicAuthInterceptor("moneyman", "1005"))
    .addInterceptor(LoggingInterceptor())
    .addInterceptor(SuccessStatusCodeInterceptor())
    .build()

  override fun get(url: String, headers: Map<String, String>): Response {
    val request = HttpRequestBuilder()
      .url(url)
      .addHeaders(headers)
      .build()
    return client.newCall(request).execute()
  }

  override fun post(url: String, headers: Map<String, String>, params: Map<String, Any>): Response {
    TODO("Not yet implemented")
  }

  override fun delete(url: String, headers: Map<String, String>): Response {
    TODO("Not yet implemented")
  }
}