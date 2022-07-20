package com.framework.test.context.constant

import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.context.Context
import com.framework.test.context.dynamic.session.SessionContext
import com.framework.test.model.config.ApplicationConfig

class MyStaticContext : Context {
  val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()

  //  val stubConfig: StubConfig = applicationConfig.stub
//  val dbSqlConfig: DbSqlConfig = applicationConfig.dbSqlConfig
//  val administrator: CrmUser = applicationConfig.crmUsers!![CrmUserRole.ADMINISTRATOR]!!
  val sessionContext = SessionContext()
}