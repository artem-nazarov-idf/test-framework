package com.framework.test.context.dynamic

import com.framework.test.context.ContextHolder

object DynamicContextHolder : ContextHolder<MyDynamicContext> {
  override val threadContext = ThreadLocal<MyDynamicContext>()
}