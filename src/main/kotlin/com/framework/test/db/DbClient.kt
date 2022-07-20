package com.framework.test.db

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session
  fun selectOneRow(): Member?
  fun selectAllRows(): List<Member>
  fun closeDbConnection()
}