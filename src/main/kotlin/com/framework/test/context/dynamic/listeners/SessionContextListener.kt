package com.framework.test.context.dynamic.listeners

import com.framework.test.constants.CookieType
import com.framework.test.context.sessionContext

class SessionContextListener : Listener {
  var jSessionIdValue: String? = ""

  init {
    sessionContext().add(this)
  }

  override fun update() {
    jSessionIdValue = sessionContext().responseCookies?.get(CookieType.J_SESSION_ID.value)
  }
}