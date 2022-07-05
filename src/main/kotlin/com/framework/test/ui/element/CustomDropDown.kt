package com.framework.test.ui.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.kotlin.Logging

object CustomDropDown : Logging {
  fun dropDownVisible(element: SelenideElement) {
    logger.info("dropdown $element visible")
    element.shouldBe(Condition.visible)
  }
}