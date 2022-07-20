package com.framework.test.context.dynamic.session

import com.framework.test.context.dynamic.listeners.Listener

class SessionContext : SessionObserver {
  override val observers: ArrayList<Listener> = ArrayList()

  var responseCookies: MutableMap<String, String>? = null
    set(value) {
      field = value
      sendUpdateEvent()
    }
}