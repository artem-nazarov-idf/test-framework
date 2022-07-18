package com.framework.test.context.dynamic.session

import com.framework.test.context.dynamic.listeners.JSessionIdListener

interface Observable {
  val observers: ArrayList<JSessionIdListener>

  fun add(observer: JSessionIdListener) {
    observers.add(observer)
  }

  fun remove(observer: JSessionIdListener) {
    observers.remove(observer)
  }

  fun sendUpdateEvent(value: String) {
    observers.forEach { it.update(value) }
  }
}