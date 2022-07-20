package com.framework.test.context.dynamic.listeners

import com.framework.test.constants.CookieType
import com.framework.test.context.dynamicContext
import com.framework.test.context.sessionContext

class SessionContextListener : Listener {
  override fun update() {
    dynamicContext().jSessionIdValue = sessionContext().responseCookies?.get(CookieType.J_SESSION_ID.value)
  }
}