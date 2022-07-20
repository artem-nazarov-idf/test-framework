package com.framework.test.context.dynamic

import com.framework.test.context.Context
import com.framework.test.context.dynamic.listeners.SessionContextListener

class MyDynamicContext : Context {
  var SLDkflsk = // здесь лежит jSessionIdValue вместо хранение в себе.

    private
  val sessionContextListener = SessionContextListener() // листенер можно только включить или выключить.

  fun getJSessionIdValue(): String? {
    return sessionContextListener.jSessionIdValue
  }
}