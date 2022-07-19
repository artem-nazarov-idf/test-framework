package com.framework.test.db

import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery

class MyDbClient(private val jdbcUrl: String, private val jdbcUser: String, private val jdbcPassword: String) :
  DbClient {
  private var session: Session? = null

  override fun getClient(): Session { // todo не факт, что это имелось ввиду.
    if (session == null) {
      try {
        session = session(url = jdbcUrl, user = jdbcUser, password = jdbcPassword)
      } catch (e: Exception) {
//        throw IdfKotlinJdbcException("MySql connection failed for $jdbcUrl", e)
      }
    }
    return session as Session
  }

  override fun selectOneRow() {
    val aliceQuery = sqlQuery("select id, name, created_at from members where name = ?", "Alice")
    val alice: Member? = session?.first(aliceQuery, toMember)
  }

  override fun selectAllRows() {
    val allMembersQuery = sqlQuery("select id, name, created_at from members")
    val members: List<Member> = session!!.list(allMembersQuery, toMember)
  }

  override fun closeDbConnection() {
    if (session != null) {
      getClient().close()
      session = null
    }
  }
}

data class Member(
  val id: Int,
  val name: String?,
  val createdAt: java.time.ZonedDateTime
)

val toMember: (Row) -> Member = { row ->
  Member(
    row.int("id"),
    row.stringOrNull("name"),
    row.zonedDateTime("created_at")
  )
}