package com.example.combolifestyle35.model

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.jvm.Synchronized


class UserRepository private constructor(comboDao: ComboDao) {
    private lateinit var mName: String
    private var mLoc: String? = null
    private var mAge: Int? = 0
    private var mSex: String? = null
    private var mActivityLvl: String? = null
    private var mWeight: Int? = 0
    private var mPhoto: Bitmap? = null

    private var mJsonUser: String? = null
    private var mUser: LiveData<UserData>? = null
    private var mComboDao: ComboDao = comboDao

    // This LiveData object that is notified when we've fetched the user
    val userData = MutableLiveData<UserData>()

    // This flow is triggered when any change happens to the database
    val allUserData: Flow<List<UserTable>> = comboDao.getAllUserData()

    fun setUserData(user: LiveData<UserData>) {
        // Cache the user info
        mUser = user
        mScope.launch(Dispatchers.IO) {
            //fetchAndParseUserData()

            // After the suspend function returns, Update the View THEN insert into db
            if (mJsonUser != null)
            // Populate live data object. But since this is happening in a background thread (the coroutine),
            // we have to use postValue rather than setValue. Use setValue if update is on main thread
                userData.postValue(JSONUserUtils.getUserData(mJsonUser))

            // insert into db. This will trigger a flow
            // that updates a recyclerview. All db ops should happen
            // on a background thread
            insert()
        }
    }

    // Insert into db
    @WorkerThread
    suspend fun insert() {
        userData.value?.apply {
            mName = user.name.toString()
            mLoc = user.loc
            mAge = user.age
            mSex = user.sex
            mActivityLvl = user.activityLvl
            mWeight = user.weight
            // TODO save user photo
        }
        mComboDao.insert(UserTable(mName, mLoc, mAge, mSex, mActivityLvl, mWeight, mJsonUser))
    }

    // Make the repository singleton (static class)
    companion object {
        private var mInstance: UserRepository? = null
        private lateinit var mScope: CoroutineScope

        @Synchronized
        fun getInstance(
            comboDao: ComboDao,
            scope: CoroutineScope
        ): UserRepository {
            mScope = scope
            return mInstance ?: synchronized(this) {
                val instance = UserRepository(comboDao)
                mInstance = instance
                instance
            }
        }
    }
}