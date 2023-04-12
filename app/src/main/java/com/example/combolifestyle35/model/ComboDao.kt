package com.example.combolifestyle35.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ComboDao {
    // Insert ignore
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userTable: UserTable)

    // Delete all
    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

    // Get all the user info that is currently in the database
    // automatically triggered when the database is updated because of Flow
    @Query("SELECT * from user_table where lower(userdata)!='Dummy_data' ORDER BY userdata")
    fun getAllUserData(): Flow<List<UserTable>>
}