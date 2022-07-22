package com.framework.test.context.dynamic.listeners

import com.framework.test.constants.CookieType.JSESSIONID
import com.framework.test.context.sessionContext
import org.openqa.selenium.Cookie

class SessionContextListener : Listener {
  override fun update() {
    val jSessionIdValue: String? = sessionContext().responseCookies?.get(JSESSIONID.name)
    sessionContext().authorizationCookie = Cookie(JSESSIONID.name, jSessionIdValue)
  }
}