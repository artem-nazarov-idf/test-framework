package com.framework.test.context.dynamic.listeners

import com.framework.test.constants.CookieType.JSESSIONID
import com.framework.test.context.dynamicContext
import com.framework.test.context.sessionContext

class SessionContextListener : Listener {
  override fun update() {
    dynamicContext().jSessionIdValue = sessionContext().responseCookies?.get(JSESSIONID.value)
  }
}