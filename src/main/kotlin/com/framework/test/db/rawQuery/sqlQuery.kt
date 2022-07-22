package com.framework.test.db.rawQuery

object sqlQuery {
  val selectUserDataFromUserAccountTableById: String = """
    select id, login, name
    from user_account
    where name = 'Sergey Shikunets'
  """.trimIndent() // название не правильное у запроса

  val crmUserSelectQuery: String = """
    select id, login, name
    from user_account
    where login like '%user%'
  """.trimIndent() // название не правильное у запроса
}