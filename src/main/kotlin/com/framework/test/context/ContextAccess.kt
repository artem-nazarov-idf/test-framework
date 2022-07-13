package com.framework.test.context

internal fun dynamicContext() = MmDynamicContextHolder.getContext() as EsccDynamicContext
internal fun loanFlowCookieSession() = dynamicContext().getCurrentSessionData().loanFlowCookieSession
internal fun cookieSession() = loanFlowCookieSession().crmAuthUserCookie