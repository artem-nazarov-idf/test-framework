package com.framework.test.db.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.framework.test.db.DbData
import com.vladsch.kotlin.jdbc.Row

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserFromUserAccount(
  val id: Int,
  val login: String?,
  val name: String?
) : DbData

val toUserFromUserAccount: (Row) -> UserFromUserAccount = { row ->
  UserFromUserAccount(
    row.int("id"),
    row.string("login"),
    row.string("name")
  )
}