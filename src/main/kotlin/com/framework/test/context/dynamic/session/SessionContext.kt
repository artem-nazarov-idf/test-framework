package com.framework.test.context.dynamic.session

import com.framework.test.context.dynamic.listeners.Listener
import org.openqa.selenium.Cookie

class SessionContext : SessionObserver {
  override val observers: ArrayList<Listener> = ArrayList()

  var authorizationCookie: Cookie? = null

  var responseCookies: MutableMap<String, String>? = null
    set(value) {
      field = value
      sendUpdateEvent()
    }
}