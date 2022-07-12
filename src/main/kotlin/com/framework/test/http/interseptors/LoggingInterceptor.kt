package com.framework.test.http.interseptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.apache.logging.log4j.kotlin.Logging

class LoggingInterceptor : Interceptor, Logging {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val requestBuffer = Buffer()

    request.body?.writeTo(requestBuffer)
    logger.info(
      """|Sending request ${request.url}
      |heders request is [${request.headers}]
      |body request is [${requestBuffer.readByteString()}]
      """.trimMargin()
    )

    val response: Response = chain.proceed(request)

    logger.info(
      """|Received response for ${response.request.url}|
      |response heders is [${response.headers}]|
      """.trimMargin()
    )

    val responseContentType = response.headers["content-type"]
    val responseContentTypeBody = response.body?.contentType()

    return when (responseContentType?.contains("application/json")) {
      true -> {
        val stringBody = response.body?.string()
        logger.info("|body is [$stringBody]|")
        response.newBuilder().body(stringBody?.toResponseBody(responseContentTypeBody)).build()
      }
      false -> {
        logger.info("|body contentType is [${responseContentType}]")
        response
      }
      null -> error("Response body is null")
    }
  }
}