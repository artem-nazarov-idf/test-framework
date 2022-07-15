package com.framework.test

import com.framework.test.context.constant.MyStaticContext
import com.framework.test.context.constant.StaticContextHolder
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext
import com.framework.test.context.dynamicContext
import com.framework.test.context.staticContext
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

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

  @BeforeAll
  fun initContext() {
    dynamicContext = MyDynamicContext()
    staticContext = MyStaticContext()
  }
}