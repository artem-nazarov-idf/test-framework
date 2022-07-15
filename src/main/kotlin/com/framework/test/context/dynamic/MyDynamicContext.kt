package com.framework.test.context.dynamic

import com.framework.test.context.Context

class MyDynamicContext : Context {
  private var jSessionIdValue: String = ""

  fun getJSessionIdValue(): String = jSessionIdValue

  fun setJSessionIdValue(jSessionIdValue: String) {
    this.jSessionIdValue = jSessionIdValue
  }
}