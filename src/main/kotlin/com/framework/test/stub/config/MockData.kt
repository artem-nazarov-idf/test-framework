package com.framework.test.stub.config

import com.framework.test.constants.RequestMethods

interface MockData {
  val method: RequestMethods
  val endpoint: String
  val responseStatusCode: Int
  val responseContentType: String
  val filePath: String
}