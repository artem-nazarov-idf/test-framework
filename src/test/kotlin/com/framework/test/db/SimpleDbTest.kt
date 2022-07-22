package com.framework.test.db

import com.framework.test.BaseTest
import com.framework.test.context.dbSqlConfig
import com.framework.test.db.rawQuery.sqlQuery
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleDbTest : BaseTest() {
  private val dbClient by lazy { MyDbClient(dbSqlConfig().url, dbSqlConfig().user, dbSqlConfig().password) }

  @AfterAll
  fun closeDbConnection() {
    dbClient.closeDbConnection()
  }

  @Test
  fun getOneRow() {
    val value: Member? = dbClient.selectOneRow(sqlQuery.selectUserDataFromUserAccountTableById)

    Assertions.assertEquals(100000, value?.id)
    Assertions.assertEquals("Sergey Shikunets", value?.name)
    Assertions.assertEquals("admmin", value?.login)
  }

  @Test
  fun getAllRow() {
    val value: List<Member> = dbClient.selectAllRows(sqlQuery.crmUserSelectQuery)

    Assertions.assertTrue(value.size > 1)
//    Assertions.assertTrue(value[0] ) todo
  }
}