package com.example.combolifestyle35

import androidx.lifecycle.MutableLiveData
import androidx.annotation.WorkerThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.jvm.Synchronized


class UserRepository private constructor(comboDao: ComboDao){

    // This LiveData object that is notified when we've fetched the user
    val userData = MutableLiveData<UserData>()

    // This flow is triggered when any change happens to the database
    val allUserData: Flow<List<UserTable>> = comboDao.getAllUserData()

    private var mName: String? = null
    private var mUser: String? = null
    private var mComboDao: ComboDao = comboDao

    fun setName(name: String) {
        // Cache the name
        mName = name

        // All database operations should be on a background thread
        mScope.launch(Dispatchers.IO){
            // Insert into database
            // Updates flow
            insert()
        }
    }

    @WorkerThread
    suspend fun insert() {
        if (mName != null) {
            mComboDao.insert(UserTable(mName!!, mUser!!))
    }
    }

    // Make the repository singleton (static class)
    companion object {
        private var mInstance: UserRepository? = null
        private lateinit var mScope: CoroutineScope
        @Synchronized
        fun getInstance(comboDao: ComboDao,
                        scope: CoroutineScope
        ): UserRepository {
            mScope = scope
            return mInstance?: synchronized(this){
                val instance = UserRepository(comboDao)
                mInstance = instance
                instance
            }
        }
    }


}