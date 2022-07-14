package com.framework.test.context

interface ContextHolder<T : Context> {
  val idfContext: ThreadLocal<T>

  fun setContext(context: T) {
    if (idfContext.get() == null) idfContext.set(context)
  }

  fun initContext(context: T): T {
    clearContext()
    setContext(context)
    return context
  }

  fun getContext(): T = idfContext.get() ?: throw IllegalStateException("Context isn't initialized")

  fun clearContext() = idfContext.remove()
}