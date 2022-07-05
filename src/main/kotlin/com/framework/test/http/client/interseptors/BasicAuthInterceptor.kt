package com.framework.test.http.client.interseptors

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor(username: String, password: String) : Interceptor {
  private val credentials: String = Credentials.basic(username, password)

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request().newBuilder()
      .header("Authorization", credentials)
      .build();

    return chain.proceed(request)
  }
}