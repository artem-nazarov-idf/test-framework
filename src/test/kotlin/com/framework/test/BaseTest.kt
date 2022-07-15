package com.framework.test

import com.framework.test.context.constant.MyStaticContext
import com.framework.test.context.constant.StaticContextHolder
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext
import com.framework.test.context.dynamicContext
import com.framework.test.context.staticContext
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {
  init {
    StaticContextHolder.initContext(MyStaticContext())
    DynamicContextHolder.initContext(MyDynamicContext())
  }

  protected var staticContext: MyStaticContext
    get() {
      return staticContext()
    }
    set(value) {
      StaticContextHolder.initContext(value)
    }

  protected var dynamicContext: MyDynamicContext
    get() {
      return dynamicContext()
    }
    set(value) {
      DynamicContextHolder.initContext(value)
    }

  @AfterAll
  fun clearContext() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}