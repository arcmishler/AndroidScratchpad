package com.example.combolifestyle35.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.combolifestyle35.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [UserTable::class], version = 1, exportSchema = false)
abstract class ComboRoomDatabase : RoomDatabase() {
    abstract fun comboDao(): ComboDao

        class Callback @Inject constructor(
            private val database: Provider<ComboRoomDatabase>,
            @ApplicationScope private val applicationScope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                val dao = database.get().comboDao()

                applicationScope.launch {
                    dao.insert(UserTable("Dummy_name", "Dummy_data"))
                }
            }
        }
//        private class RoomDatabaseCallback(
//            private val scope: CoroutineScope
//        ): RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                mInstance?.let { database ->
//                    scope.launch(Dispatchers.IO){
//                        populateDbTask(database.comboDao())
//                    }
//                }
//            }
//        }

//        suspend fun populateDbTask (comboDao: ComboDao) {
//            comboDao.insert(UserTable("Dummy_name", "Dummy_data"))
//        }
    }
//}