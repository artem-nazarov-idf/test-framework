package com.framework.test.stub.config

import com.framework.test.constants.RequestMethods
import java.util.*

interface MockData {
  var id: UUID?
  val priority: Int
  val method: RequestMethods
  val endpoint: String
  val responseStatusCode: Int
  val responseHeaders: Map<String, String>?
  val filePath: String
}