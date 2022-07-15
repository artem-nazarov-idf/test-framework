package com.framework.test.http.client

import com.framework.test.constants.HttpClientDefaultTimeouts.DEFAULT_CONNECT_SECONDS_TIMEOUT
import com.framework.test.constants.HttpClientDefaultTimeouts.DEFAULT_READ_SECONDS_TIMEOUT
import com.framework.test.http.interseptors.BasicAuthInterceptor
import com.framework.test.http.interseptors.LoggingInterceptor
import com.framework.test.http.interseptors.SuccessStatusCodeInterceptor
import com.framework.test.model.config.ApplicationConfig
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpClientBuilder(private val applicationConfig: ApplicationConfig) {

  fun buildDefaultClient(
    connectSecondsTimeout: Long = DEFAULT_CONNECT_SECONDS_TIMEOUT,
    readSecondsTimeout: Long = DEFAULT_READ_SECONDS_TIMEOUT
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(connectSecondsTimeout, TimeUnit.SECONDS)
      .readTimeout(readSecondsTimeout, TimeUnit.SECONDS)
      .addInterceptor(BasicAuthInterceptor(applicationConfig.userName!!, applicationConfig.password!!))
      .addInterceptor(LoggingInterceptor())
      .addInterceptor(SuccessStatusCodeInterceptor())
      .build()
  }
}
