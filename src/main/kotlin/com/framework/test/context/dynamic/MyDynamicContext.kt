package com.framework.test.context.dynamic

import com.framework.test.context.Context
import com.framework.test.context.dynamic.listeners.SessionContextListener
import com.framework.test.context.dynamic.session.SessionContext

class MyDynamicContext : Context {
  var jSessionIdValue: String? = null

  val sessionContext = SessionContext()
  private val sessionContextListener = SessionContextListener()

  init {
    sessionContext.add(sessionContextListener)
  }
}