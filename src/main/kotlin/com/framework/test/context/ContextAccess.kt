package com.framework.test.context

import com.framework.test.context.constant.MyStaticContext
import com.framework.test.context.constant.StaticContextHolder
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext

internal fun dynamicContext(): MyDynamicContext = DynamicContextHolder.getContext()
internal fun staticContext(): MyStaticContext = StaticContextHolder.getContext()
internal fun applicationConfig() = staticContext().getApplicationConfig()
internal fun stubConfig() = staticContext().getStubConfig()
internal fun administrator() = staticContext().getAdministrator()

internal fun jSessionIdValue() = dynamicContext().getJSessionIdValue()
