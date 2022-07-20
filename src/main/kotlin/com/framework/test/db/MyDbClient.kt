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

  override fun selectOneRow(): Int? {
    val aliceQuery = sqlQuery("select id from user_account where login = 'ospanova77@bk.ru'") // тут
    // пока адский хардкод
    val good: Boolean = getClient().execute(aliceQuery)
    return getClient().first(aliceQuery) { row -> row.int("id") }
  }

  override fun selectAllRows(): List<Member> {
    val allMembersQuery = sqlQuery("select id, name, created_at from members")
    return getClient().list(allMembersQuery, toMember)
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
  val login: String,
  val name: String
)

// todo вынести отдельно
val toMember: (Row) -> Member = { row ->
  Member(
    row.int("id"),
    row.string("login"),
    row.string("name"),
  )
}