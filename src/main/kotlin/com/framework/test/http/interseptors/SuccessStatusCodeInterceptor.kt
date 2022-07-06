package com.framework.test.http.interseptors

import okhttp3.Interceptor
import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging

class SuccessStatusCodeInterceptor : Interceptor, Logging {
  override fun intercept(chain: Interceptor.Chain): Response {
    val response: Response = chain.proceed(chain.request())

    assert(response.isSuccessful) {
      """
      |Not valid http status code [${response.code}] returned in response
      |Request url [${response.request.url}]
      """.trimMargin()
    }

    return response
  }
}