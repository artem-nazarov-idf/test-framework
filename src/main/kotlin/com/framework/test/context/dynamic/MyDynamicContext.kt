package com.framework.test.context.dynamic

import com.framework.test.context.Context
import com.framework.test.context.dynamic.listeners.SessionContextListener

class MyDynamicContext : Context {
  private val sessionContextListener = SessionContextListener()

  fun getJSessionIdValue(): String? {
    return sessionContextListener.jSessionIdValue
  }
}