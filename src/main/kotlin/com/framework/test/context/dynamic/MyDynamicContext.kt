package com.framework.test.context.dynamic

import com.framework.test.context.Context
import com.framework.test.context.dynamic.listeners.ReaderJSessionIdValue
import com.framework.test.context.dynamic.session.JSessionIdUpdater

class MyDynamicContext : Context {
  private val jSessionIdUpdater = JSessionIdUpdater()
  private val readerJSessionIdValue = ReaderJSessionIdValue(jSessionIdUpdater)

  fun getJSessionId(): String = readerJSessionIdValue.jSessionIdValue
  fun getJSessionIdUpdater(): JSessionIdUpdater = jSessionIdUpdater
}