package com.framework.test.context.dynamic

import com.framework.test.context.Context

interface MyDynamicContext : Context {
  var currentSession: MmSessionContext = this.initCurrentSessionContext()
  fun getCurrentSessionData(): MmSessionContext = currentSession
}