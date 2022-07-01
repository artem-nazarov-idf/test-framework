package com.framework.test.ui.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.kotlin.Logging

object CustomClick : Logging {
  fun clickButton(element: SelenideElement) {
    logger.info("Click button: ${element.text()}")
    element
      .shouldBe(Condition.enabled)
      .click()
  }
}