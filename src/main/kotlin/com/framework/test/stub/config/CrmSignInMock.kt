package com.framework.test.stub.config

import com.framework.test.constants.RequestMethods
import java.util.*

class CrmSignInMock : MockData {
  override var id: UUID? = null
  override val priority = 1
  override val method = RequestMethods.POST
  override val endpoint = "/secure/rest/sign/in"
  override val responseStatusCode = 200
  override val responseHeaders = mapOf("Content-Type" to "application/json")
  override val filePath = "crm-sign-in-admin-ok.json"
}