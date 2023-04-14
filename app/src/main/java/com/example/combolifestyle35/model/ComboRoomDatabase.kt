package com.example.combolifestyle35.model

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [UserTable::class], version = 2, exportSchema = false)
abstract class ComboRoomDatabase : RoomDatabase() {
    abstract fun comboDao(): ComboDao

     // Make the database singleton.
    companion object {
        @Volatile
        private var mInstance: ComboRoomDatabase? = null
        fun getDatabase(
            context: Context,
            scope : CoroutineScope
        ): ComboRoomDatabase {
            return mInstance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ComboRoomDatabase::class.java, "comboApp.db"
                )
                    .addCallback(RoomDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                mInstance = instance
                instance
            }
        }

        private class RoomDatabaseCallback(
            private val scope: CoroutineScope
        ): RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                mInstance?.let { database ->
                    scope.launch(Dispatchers.IO){
                        populateDbTask(database.comboDao())
                    }
                }
            }
        }

        suspend fun populateDbTask (comboDao: ComboDao) {
            comboDao.insert(UserTable("Dummy_name", "d_loc", 0, "d_sex", "d_activity", 0, "dummy_Json"))
        }
    }
}