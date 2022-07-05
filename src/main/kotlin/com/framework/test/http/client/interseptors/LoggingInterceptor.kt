package com.framework.test.http.client.interseptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.apache.logging.log4j.kotlin.Logging

class LoggingInterceptor : Interceptor, Logging {
  override fun intercept(chain: Interceptor.Chain): Response {
    var request: Request = chain.request();

    logger.info(
      "Sending request ${request.url} on ${chain.connection()}, heders is [${request.headers}]" +
          ", body is [${request.body}]"
    )

    var response: Response = chain.proceed(request);

    logger.info(
      "Received response for ${response.request.url} in [${response.headers}]" +
          ", body is [${request.body}]"
    )

    return response;
  }
}
