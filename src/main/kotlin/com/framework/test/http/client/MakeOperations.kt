package com.framework.test.http.client

import okhttp3.Response

interface MakeOperations {
  fun get(
    url: String,
    headers: Map<String, String> = mapOf()
  ): Response

  fun post(
    url: String,
    headers: Map<String, String> = mapOf(),
    params: Map<String, Any> = emptyMap()
  ): Response

  fun delete(
    url: String,
    headers: Map<String, String> = mapOf(),
  ): Response
}