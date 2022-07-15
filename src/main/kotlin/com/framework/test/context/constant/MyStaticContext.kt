package com.framework.test.context.constant

import com.framework.test.application.config.factory.ApplicationConfigReaderFactory
import com.framework.test.context.Context
import com.framework.test.model.config.Administrator
import com.framework.test.model.config.ApplicationConfig
import com.framework.test.model.config.StubConfig

class MyStaticContext : Context {
  private val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getApplicationConfigFromFile()
  private val stubConfig: StubConfig = applicationConfig.stub
  private val administrator: Administrator = applicationConfig.crmUsers!!.administrator

  fun getApplicationConfig(): ApplicationConfig = applicationConfig
  fun getStubConfig(): StubConfig = stubConfig
  fun getAdministrator(): Administrator = administrator
}