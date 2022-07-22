package com.framework.test.db

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session

  fun selectOneRow(
    sqlQueryRaw: String,
    queryParams: Map<String, Any> = mapOf(),
  ): Member?

  fun selectAllRows(
    sqlQueryRaw: String,
    queryParams: Map<String, Any> = mapOf(),
  ): List<Member>

  fun closeDbConnection()
}