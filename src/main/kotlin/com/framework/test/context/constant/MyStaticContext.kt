package com.framework.test.context.constant

import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.constants.CrmUserRole
import com.framework.test.context.Context
import com.framework.test.context.dynamic.session.SessionContext
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.model.config.CrmUser
import com.framework.test.model.config.StubConfig

class MyStaticContext : Context {
  val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()
  val stubConfig: StubConfig = applicationConfig.stub
  val administrator: CrmUser = applicationConfig.crmUsers!![CrmUserRole.ADMINISTRATOR]!!
  val sessionContext = SessionContext()
}