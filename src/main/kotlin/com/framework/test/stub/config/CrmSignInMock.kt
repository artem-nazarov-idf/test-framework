package com.framework.test.stub.config

import com.framework.test.constants.RequestMethods

class CrmSignInMock : MockData {
  override val method = RequestMethods.POST
  override val endpoint = "/secure/rest/sign/in"
  override val responseStatusCode = 200
  override val responseContentType = "application/json"
  override val filePath = "crm-sign-in-admin-ok.json"
}