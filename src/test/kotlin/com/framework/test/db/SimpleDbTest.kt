package com.framework.test.db

import com.framework.test.BaseTest
import com.framework.test.db.models.UserFromUserAccount
import com.framework.test.db.models.toUserFromUserAccount
import com.framework.test.db.rawQuery.SqlQuery
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleDbTest : BaseTest() {
  private val actualOneUser: DbData? =
    MyDbClient.selectOneRow(SqlQuery.recentCrmUsersSelectQuery, toUserFromUserAccount)
  private val actualManyUser: List<DbData> =
    MyDbClient.selectAllRows(SqlQuery.recentCrmUsersSelectQuery, toUserFromUserAccount)

  @AfterAll
  fun closeDbConnection() {
    MyDbClient.closeDbConnection()
  }

  @Test
  fun `select one row to get first user`() {
    Assertions.assertEquals(actualOneUser, actualManyUser[0])
  }

  @Test
  fun `select all rows to get more than one record`() {
    Assertions.assertTrue(actualManyUser.size > 1, "actualManyUser size is ${actualManyUser.size}")
  }

  @Test
  fun `get specific user by name`() {
    val actualSpecificUser: UserFromUserAccount? =
      MyDbClient.selectOneRow(
        SqlQuery.getSpecificUserByNameSelectQuery,
        toUserFromUserAccount, mapOf("name" to "Пиппп Рмари")
      ) as UserFromUserAccount?
    Assertions.assertEquals("Пиппп Рмари", actualSpecificUser?.name)
  }
}