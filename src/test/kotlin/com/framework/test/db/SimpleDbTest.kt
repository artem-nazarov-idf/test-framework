package com.framework.test.db

import com.framework.test.BaseTest
import com.framework.test.context.dbSqlConfig
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
  fun testExample() {
    val value: Member? = dbClient.selectOneRow()

    Assertions.assertEquals(10000, value?.id)
  }
}