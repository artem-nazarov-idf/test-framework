package com.framework.test.ui.page

import com.codeborne.selenide.Selenide
import org.apache.logging.log4j.kotlin.Logging

abstract class BasePage : Logging {
  abstract val urlPage: String

  fun openPage() {
    logger.info("open $urlPage")
    Selenide.open(urlPage)
  }
}