package com.framework.test.api.testWithStub

import com.framework.test.api.crm.login.model.response.CrmUserInfoResponse
import com.framework.test.api.crm.operations.CrmApiOperations
import com.framework.test.context.administrator
import com.framework.test.context.applicationConfig
import com.framework.test.stub.config.CrmSignInMock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SimpleApiTestWithStub : WireMockBaseTest() {
  private val crmSignInMock by lazy { CrmSignInMock() }
  private val expectedUserInfo by lazy {
    CrmUserInfoResponse(
      id = 1000000, localizedRole = "Администратор",
      partnerType = null, role = null, roleId = 10, userName = "Sergey Shikunets"
    )
  }

  @BeforeEach
  fun setStub() {
    stubController.addStub(crmSignInMock)
    stubController.verifyStub(crmSignInMock)
  }

  @AfterEach
  fun deleteStub() {
    stubController.deleteStub(crmSignInMock)
  }

  @ParameterizedTest
  @ValueSource(strings = ["http://127.0.0.1:8080", "https://qa-delivery-solva-kz-release.moneyman.ru"])
  fun `success login in crm system with stub and without stub`(baseUrl: String) {
    applicationConfig().host = baseUrl
    CrmApiOperations().apply {
      val actualUserInfo: CrmUserInfoResponse = loginToCrm(administrator())
      verifyResponseSingInSuccess(expectedUserInfo, actualUserInfo)
    }
  }
}
