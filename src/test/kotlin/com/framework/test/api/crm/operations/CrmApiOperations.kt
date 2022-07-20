package com.framework.test.api.crm.operations

import com.framework.test.api.crm.login.controller.CrmAuthorizationController
import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.model.config.CrmUser
import org.junit.jupiter.api.Assertions

class CrmApiOperations {
  private val loginController by lazy { CrmAuthorizationController() }

  fun loginToCrm(crmUser: CrmUser): CrmUserInfoResponse {
    return loginController.postCrmAuthorisation(crmUser)
  }

  fun verifyResponseSingInSuccess(
    expectedCrmUserInfo: CrmUserInfoResponse,
    actualCrmUserInfo: CrmUserInfoResponse
  ) {
    Assertions.assertEquals(expectedCrmUserInfo.id, actualCrmUserInfo.id)
    Assertions.assertEquals(expectedCrmUserInfo.localizedRole, actualCrmUserInfo.localizedRole)
    Assertions.assertEquals(expectedCrmUserInfo.roleId, actualCrmUserInfo.roleId)
    Assertions.assertEquals(expectedCrmUserInfo.userName, actualCrmUserInfo.userName)
  }
}