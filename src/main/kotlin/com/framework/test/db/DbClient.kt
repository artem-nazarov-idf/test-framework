package com.framework.test.db

import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session

  fun selectOneRow(
    sqlQueryRaw: String,
    extractor: (Row) -> DbData,
    queryParams: Map<String, Any> = mapOf()
  ): DbData?

  fun selectAllRows(
    sqlQueryRaw: String,
    extractor: (Row) -> DbData,
    queryParams: Map<String, Any> = mapOf()
  ): List<DbData>

  fun closeDbConnection()
}