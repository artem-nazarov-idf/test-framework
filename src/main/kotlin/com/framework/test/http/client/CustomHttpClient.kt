package com.framework.test.http.client

import okhttp3.OkHttpClient
import okhttp3.Response

class CustomHttpClient : MakeOperations {
  private val client by lazy { OkHttpClient() }

  override fun get(url: String, headers: Map<String, String>): Response {
    val request = HttpRequestBuilder().url(url).return //TODO("Надо дописать.")
  }

  override fun post(url: String, headers: Map<String, String>, params: Map<String, Any>): Response {
    TODO("Not yet implemented")
  }

  override fun delete(url: String, headers: Map<String, String>): Response {
    TODO("Not yet implemented")
  }
}