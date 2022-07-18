package com.framework.test.context.dynamic.listeners

import com.framework.test.context.dynamic.session.JSessionIdUpdater

class ReaderJSessionIdValue(private var jSessionIdUpdater: JSessionIdUpdater) : JSessionIdListener {
  var jSessionIdValue: String = ""

  init {
    jSessionIdUpdater.add(this)
  }

  override fun update(value: String) {
    jSessionIdValue = jSessionIdUpdater.jSessionId
  }
}