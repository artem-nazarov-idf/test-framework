package com.framework.test.context

interface ContextHolder<T : Context> {
  val threadContext: ThreadLocal<T>

  fun setContext(context: T) {
    if (threadContext.get() == null) threadContext.set(context)
  }

  fun initContext(context: T): T {
    clearContext()
    setContext(context)
    return context
  }

  fun getContext(): T = threadContext.get() ?: error("Context isn't initialized")

  fun clearContext() = threadContext.remove()
}