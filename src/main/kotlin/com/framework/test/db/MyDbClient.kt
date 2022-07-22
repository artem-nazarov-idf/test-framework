package com.framework.test.db

import com.framework.test.context.dbSqlConfig
import com.mysql.cj.jdbc.exceptions.MySQLTimeoutException
import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery

object MyDbClient : DbClient {
  private val jdbcUrl = dbSqlConfig().url
  private val jdbcUser = dbSqlConfig().user
  private val jdbcPassword = dbSqlConfig().password
  private var session: Session? = null

  override fun getClient(): Session {
    if (session == null) {
      try {
        session = session(url = jdbcUrl, user = jdbcUser, password = jdbcPassword)
      } catch (e: Exception) {
        throw MySQLTimeoutException("MySql connection failed for $jdbcUrl")
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