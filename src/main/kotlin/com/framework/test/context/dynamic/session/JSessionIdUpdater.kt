package com.framework.test.context.dynamic.session

import com.framework.test.context.dynamic.listeners.JSessionIdListener

class JSessionIdUpdater : Observable {
  override val observers: ArrayList<JSessionIdListener> = ArrayList()

  var jSessionId = ""
    set(value) {
      field = value
      sendUpdateEvent(value)
    }
}