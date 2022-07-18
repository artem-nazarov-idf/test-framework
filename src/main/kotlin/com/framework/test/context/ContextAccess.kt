package com.framework.test.context

import com.framework.test.context.constant.MyStaticContext
import com.framework.test.context.constant.StaticContextHolder
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext
import com.framework.test.context.dynamic.session.JSessionIdUpdater
import com.framework.test.model.config.Administrator
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.model.config.StubConfig

internal fun dynamicContext(): MyDynamicContext = DynamicContextHolder.getContext()
internal fun staticContext(): MyStaticContext = StaticContextHolder.getContext()
internal fun applicationConfig(): ApplicationConfig = staticContext().getApplicationConfig()
internal fun stubConfig(): StubConfig = staticContext().getStubConfig()
internal fun administrator(): Administrator = staticContext().getAdministrator()
internal fun jSessionId(): String = dynamicContext().getJSessionId()
internal fun jSessionIdUpdater(): JSessionIdUpdater = dynamicContext().getJSessionIdUpdater()
