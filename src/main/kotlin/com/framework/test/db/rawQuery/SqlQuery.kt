package com.framework.test.db.rawQuery

import com.framework.test.context.applicationConfig

object SqlQuery {
  private val mainSchema = applicationConfig().dbSqlConfig.mainSchema

  val recentCrmUsersSelectQuery: String = """
    select id, login, name
    from $mainSchema.user_account
    order by id desc
    limit 500
  """.trimIndent()

  val getSpecificUserByNameSelectQuery: String = """
    select id, login, name
    from $mainSchema.user_account
    where name = :name
  """.trimIndent()
}