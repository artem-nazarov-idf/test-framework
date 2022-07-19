package com.framework.test.db

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session
  fun selectOneRow()
  fun selectAllRows()
  fun closeDbConnection()
}