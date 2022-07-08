package com.framework.test.http.verifiers

import com.framework.test.http.operations.ResponseOperations
import okhttp3.Response
import org.junit.jupiter.api.Assertions

class ResponseNotEmptyVerifier {
  fun verifyResponseNotEmptyBody(response: Response) {
    Assertions.assertTrue(!response.body.toString().isNullOrBlank(), "response body not empty")
  // TODO: 07.07.2022  проверить это на стабе.
  }

  fun verifyResponseNotEmptyCookieValue(response: Response, cookieName: String) {
    val cookieValue: String = ResponseOperations().getCookieValueFromResponse(response, cookieName)
    Assertions.assertTrue(!cookieValue.isNullOrBlank(), "cookie [$cookieName] value is empty")
  }
}