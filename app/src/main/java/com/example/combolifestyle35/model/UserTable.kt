package com.example.combolifestyle35.model

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "user_table")
data class UserTable(
    @field:ColumnInfo(name = "name")
    @field:PrimaryKey
    var name: String,
    @field:ColumnInfo(
        name = "userdata"
    ) var userJson: String
)