package com.framework.test.context.dynamic

import com.framework.test.context.Context
import com.framework.test.context.dynamic.listeners.SessionContextListener
import com.framework.test.context.dynamic.session.SessionContext

class MyDynamicContext : Context {
  val sessionContext = SessionContext()

  init {
    sessionContext.add(SessionContextListener())
  }
}