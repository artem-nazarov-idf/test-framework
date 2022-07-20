package com.framework.test.context.dynamic.session

import com.framework.test.context.dynamic.listeners.Listener

interface SessionObserver {
  val observers: ArrayList<Listener>

  fun add(observer: Listener) {
    observers.add(observer)
  }

  fun remove(observer: Listener) {
    observers.remove(observer)
  }

  fun sendUpdateEvent() {
    observers.forEach { it.update() }
  }
}