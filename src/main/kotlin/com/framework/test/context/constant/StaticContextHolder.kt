package com.framework.test.context.constant

import com.framework.test.context.ContextHolder

object StaticContextHolder : ContextHolder<MyStaticContext> {
  override val threadContext = ThreadLocal<MyStaticContext>()
}