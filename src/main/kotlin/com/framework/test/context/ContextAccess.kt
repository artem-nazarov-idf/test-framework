package com.framework.test.context

import com.framework.test.api.crm.login.model.request.CrmAuthorizationRequest
import com.framework.test.context.dynamic.DynamicContextHolder

internal fun dynamicContext() = DynamicContextHolder.getContext()
internal fun loanFlowCookieSession() = dynamicContext().getCurrentSessionData().loanFlowCookieSession
internal fun cookieSession() = loanFlowCookieSession().crmAuthUserCookie
internal fun adminData(): CrmAuthorizationRequest =
  dynamicContext().getCurrentBorrowerConfig().user() as CrmAuthorizationRequest
