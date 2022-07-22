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

  override fun getClient(): Session { // todo не факт, что это имелось ввиду.
    if (session == null) {
      try {
        session = session(url = jdbcUrl, user = jdbcUser, password = jdbcPassword)
      } catch (e: Exception) {
//        throw IdfKotlinJdbcException("MySql connection failed for $jdbcUrl", e)
        throw MySQLQueryInterruptedException("MySql connection failed for $jdbcUrl") // наваял на коленке, надо поменять
      }
    }
    return session as Session
  }

  override fun selectOneRow(
    sqlQueryRaw: String,
    queryParams: Map<String, Any>,
  ): Member? {
    val sqlQuery =
//      sqlQuery("select id,login,name from user_account where name = 'Sergey Shikunets'") // тут пока хардкод.
      sqlQuery(sqlQueryRaw, queryParams) // тут пока хардкод.
    return getClient().first(sqlQuery, toMember)
  }

  override fun selectAllRows(
    sqlQueryRaw: String,
    queryParams: Map<String, Any>,
  ): List<Member> {
    val sqlQuery =
//      sqlQuery("select id,login,name from user_account where name = 'Sergey Shikunets'") // тут пока хардкод.
      sqlQuery(sqlQueryRaw, queryParams) // тут пока хардкод.
    return getClient().list(sqlQuery, toMember)
  }

  override fun closeDbConnection() {
    if (session != null) {
      getClient().close()
      session = null
    }
  }
}

// todo вынести отдельно
data class Member(
  val id: Int,
  val login: String?,
  val name: String?
) {
  init {
    println(this.id)
  }
}

// todo вынести отдельно
val toMember: (Row) -> Member = { row ->
  Member(
    row.int("id"),
    row.string("login"),
    row.string("name")
  )
}