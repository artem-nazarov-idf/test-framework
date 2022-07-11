package com.framework.test.http.verifiers

import com.framework.test.http.converters.CookieConverter
import okhttp3.Response
import org.junit.jupiter.api.Assertions

class ResponseNotEmptyVerifier {
  fun verifyResponseNotEmptyBody(response: Response) {
    Assertions.assertTrue(!response.body?.string().isNullOrBlank(), "response body not empty")
  }

  fun verifyResponseNotEmptyCookieValue(response: Response, cookieName: String) {
    val cookieValue: String = CookieConverter().getCookieValueFromResponse(response, cookieName)
    Assertions.assertTrue(!cookieValue.isNullOrBlank(), "cookie [$cookieName] value is empty")
  }
}