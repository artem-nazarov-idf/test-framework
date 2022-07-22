package com.framework.test.db

import com.mysql.jdbc.exceptions.jdbc4.MySQLQueryInterruptedException
import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery

class MyDbClient(
  private val jdbcUrl: String, private val jdbcUser: String, private val jdbcPassword: String
) :
  DbClient {
  private var session: Session? = null

  override fun getClient(): Session {
    if (session == null) {
      try {
        session = session(url = jdbcUrl, user = jdbcUser, password = jdbcPassword)
      } catch (e: Exception) {
        throw MySQLQueryInterruptedException("MySql connection failed for $jdbcUrl")
      }
    }
    return session as Session
  }

  override fun selectOneRow(
    sqlQueryRaw: String,
    extractor: (Row) -> DbData,
    queryParams: Map<String, Any>
  ): DbData? {
    val sqlQuery = sqlQuery(sqlQueryRaw, queryParams)
    return getClient().first(sqlQuery, extractor)
  }

  override fun selectAllRows(
    sqlQueryRaw: String,
    extractor: (Row) -> DbData,
    queryParams: Map<String, Any>
  ): List<DbData> {
    val sqlQuery = sqlQuery(sqlQueryRaw, queryParams)
    return getClient().list(sqlQuery, extractor)
  }

  override fun closeDbConnection() {
    if (session != null) {
      getClient().close()
      session = null
    }
  }
}