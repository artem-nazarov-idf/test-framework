package com.framework.test.api.testWithStub

import com.framework.test.api.crm.operations.CrmOperations
import com.framework.test.stub.config.CrmSignInMock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SimpleApiTestWithStub : WireMockBaseTest() {
  private val crmSignInMock by lazy { CrmSignInMock() }

  @BeforeEach
  fun setStub() {
    wireMockService.addStub(crmSignInMock)
    wireMockService.verifyStub(crmSignInMock)
  }

  @AfterEach
  fun deleteStub() {
    wireMockService.deleteStub(crmSignInMock)
  }

  @ParameterizedTest
  @ValueSource(strings = ["http://127.0.0.1:8081", "https://qa-delivery-solva-kz-master.moneyman.ru"])
  fun `success login in crm system with stub and without stub`(baseUrl: String) {
    val endpoint = crmSignInMock.endpoint

    with(applicationConfig.crmUsers?.administrator!!) {
      CrmOperations(endpoint).apply {
        with(loginToCrm(login!!, password!!, captcha!!, baseUrl)) {
          verifyResponseSuccess(this)
        }
      }
    }
  }
}
