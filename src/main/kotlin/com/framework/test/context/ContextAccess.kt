package com.framework.test.context

import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext

internal fun dynamicContext(): MyDynamicContext = DynamicContextHolder.getContext()
internal fun jSessionIdValue() = dynamicContext().getJSessionIdValue()
internal fun setJSessionIdValue(value: String) = dynamicContext().setJSessionIdValue(value)
