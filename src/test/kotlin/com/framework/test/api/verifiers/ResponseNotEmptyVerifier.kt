package com.framework.test.api.verifiers

import com.framework.test.api.operations.ResponseOperations
import okhttp3.Response
import org.junit.jupiter.api.Assertions

class ResponseNotEmptyVerifier {
  fun verifyResponseNotEmptyBody(response: Response) {
    Assertions.assertTrue(response.body.toString().isNotEmpty(), "response body not empty")
  }

  fun verifyResponseNotEmptyCookieValue(response: Response, cookieName: String) {
    val cookieValue: String = ResponseOperations().getCookieValueFromResponse(response, cookieName)
    Assertions.assertTrue(cookieValue.isNotEmpty(), "cookie [$cookieName] value is empty")
  }
}