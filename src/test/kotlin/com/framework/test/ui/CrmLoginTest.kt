package com.framework.test.ui

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$x`
import com.codeborne.selenide.Selenide.open
import com.framework.test.config.model.ApplicationConfig
import com.framework.test.config.provider.applicationConfig.factory.ApplicationConfigReaderFactory
import com.framework.test.config.provider.driver.factory.WebDriverFactory
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.By

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CrmLoginTest {
  val applicationConfig: ApplicationConfig =
    ApplicationConfigReaderFactory().getAppConfigReaderFactory().getConfigFromFile()
  val init = WebDriverFactory().getDriverConfigReaderFactory().setDriverConfig()

  @Test
  fun `success login crm to administrator`() {
    open("${applicationConfig.host}${applicationConfig.crmLoginEndpoint}")
    `$`(By.name("username")).setValue(applicationConfig.crmUsers.administrator.login)
    `$`(By.name("password")).setValue(applicationConfig.crmUsers.administrator.password)
    `$`(By.cssSelector("[ng-model='loginData.captcha']")).setValue(applicationConfig.crmUsers.administrator.captcha)
    `$x`("//button[@type='submit']").click()

    `$`(By.id("mainNav")).should(Condition.visible)
  }
}