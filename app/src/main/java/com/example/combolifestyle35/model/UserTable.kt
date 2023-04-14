package com.example.combolifestyle35.model

import android.graphics.Bitmap
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "user_table")
data class UserTable(
    @field:ColumnInfo(name = "name")
    @PrimaryKey
    var name: String,
    @field:ColumnInfo(name = "location")
    var loc: String?,
    var age: Int?,
    var sex: String?,
    var activityLvl: String?,
    var weight: Int?,
    @field:ColumnInfo(
        name = "userdata"
    ) var userJson: String?
)