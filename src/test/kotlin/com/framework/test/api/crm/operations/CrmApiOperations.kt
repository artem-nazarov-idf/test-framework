package com.framework.test.api.crm.operations

import com.framework.test.api.crm.login.controller.CrmAuthorizationController
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.model.config.CrmUser

class CrmApiOperations {
  private val loginController by lazy { CrmAuthorizationController() }

  fun loginToCrm(crmUser: CrmUser): CrmUserInfoResponse {
    return loginController.postCrmAuthorisation(crmUser)
  }
}