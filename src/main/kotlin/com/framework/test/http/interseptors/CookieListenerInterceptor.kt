package com.framework.test.http.interseptors

import com.framework.test.context.sessionContext
import com.framework.test.http.converters.CookieConverter
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging

class CookieListenerInterceptor : Interceptor, Logging {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    val actualCookie: MutableMap<String, String> = CookieConverter(response).getCookiesFromResponse()
    val currentCookie: MutableMap<String, String>? = sessionContext().responseCookies

    if (actualCookie != currentCookie) {
      logger.info("update cookie with $actualCookie")
      sessionContext().responseCookies = CookieConverter(response).getCookiesFromResponse()
    }
    return response
  }
}
