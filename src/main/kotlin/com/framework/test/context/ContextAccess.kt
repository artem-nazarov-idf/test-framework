package com.framework.test.context

import com.framework.test.constants.CrmUserRole
import com.framework.test.context.constant.MyStaticContext
import com.framework.test.context.constant.StaticContextHolder
import com.framework.test.context.dynamic.DynamicContextHolder
import com.framework.test.context.dynamic.MyDynamicContext
import com.framework.test.context.dynamic.session.SessionContext
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.model.config.CrmUser
import com.framework.test.model.config.DbSqlConfig
import com.framework.test.model.config.StubConfig

internal fun staticContext(): MyStaticContext = StaticContextHolder.getContext()
internal fun applicationConfig(): ApplicationConfig = staticContext().applicationConfig
internal fun stubConfig(): StubConfig = staticContext().applicationConfig.stub
internal fun dbSqlConfig(): DbSqlConfig = staticContext().applicationConfig.dbSqlConfig
internal fun administrator(): CrmUser = staticContext().applicationConfig.crmUsers!![CrmUserRole.ADMINISTRATOR]!!
internal fun sessionContext(): SessionContext = staticContext().sessionContext
internal fun dynamicContext(): MyDynamicContext = DynamicContextHolder.getContext()
internal fun jSessionId(): String? = dynamicContext().getJSessionIdValue()
