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

  fun verifyResponseSuccessAdminLogin(actualResponseBody: CrmUserInfoResponse) {
    Assertions.assertEquals(1000000, actualResponseBody.id)
    Assertions.assertEquals("Администратор", actualResponseBody.localizedRole)
    Assertions.assertEquals(10, actualResponseBody.roleId)
    Assertions.assertEquals("Sergey Shikunets", actualResponseBody.userName)
    // вынести в тест.
  }
}