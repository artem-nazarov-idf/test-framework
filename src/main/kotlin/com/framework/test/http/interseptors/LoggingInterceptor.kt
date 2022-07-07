package com.framework.test.http.interseptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging

class LoggingInterceptor : Interceptor, Logging {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()

    logger.info(
      """|Sending request ${request.url}
      |heders is [${request.headers}]
      |body is [${request.body}]
      """.trimMargin()
    )

    val response: Response = chain.proceed(request)

    logger.info(
      """|Received response for ${response.request.url}|
      |response heders is [${response.headers}]|
      """.trimMargin()
    )

    val responseContentType = response.headers["content-type"]

    if (!responseContentType.isNullOrEmpty() && responseContentType == "application/json")
      logger.info(
        "|body is [${response.body?.byteString()}]|"
      ) else {
      logger.info("|body contentType is [$responseContentType]")
    }

    return response
  }
}