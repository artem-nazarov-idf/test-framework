package com.framework.test.ui.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.kotlin.Logging

object CustomInput : Logging {

  fun setInputField(element: SelenideElement, value: String?) {
    logger.info("Set Input ${element.name()} value [$value]")
    element
      .shouldBe(Condition.visible, Condition.enabled)
      .setValue(value)
  }
}