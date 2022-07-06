package com.framework.test.http.client

import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.internal.EMPTY_REQUEST

interface MakeRequest {
  fun get(
    endpoint: String,
    params: Map<String, Any> = emptyMap(),
    headers: Map<String, String> = mapOf(),
    cookies: Map<String, String>? = emptyMap(),
  ): Response

  fun post(
    endpoint: String,
    headers: Map<String, String> = mapOf(),
    requestBody: RequestBody = EMPTY_REQUEST,
    cookies: Map<String, String>? = emptyMap(),
    params: Map<String, Any> = emptyMap(),
  ): Response

  fun delete(
    endpoint: String,
    headers: Map<String, String> = mapOf(),
    requestBody: RequestBody? = null,
    cookies: Map<String, String>? = emptyMap(),
    params: Map<String, Any> = emptyMap(),
  ): Response
}