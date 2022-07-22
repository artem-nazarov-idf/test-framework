package com.framework.test.db.rawQuery

import com.framework.test.context.applicationConfig

object SqlQuery {
  private val mainShema = applicationConfig().dbSqlConfig.mainSchema // todo вынести в контекст

  val recentCrmUsersSelectQuery: String = """
    select id, login, name
    from $mainShema.user_account
    order by id desc
    limit 0,500
  """.trimIndent() // название не правильное у запроса todo

  val creditSelectQuery: String = """
    select
    creditTableFields
    from borrowerDbSchema.credit cr
    where cr.id = :creditId
  """.trimIndent() // todo взято из проекта видимо :creditId это параметр, там билдером это билдится.!!!
}