package com.example.combolifestyle35.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.combolifestyle35.R
import com.example.combolifestyle35.model.UserData
import com.example.combolifestyle35.model.UserRepository
import com.example.combolifestyle35.model.UserTable

class ComboViewModel(repository: UserRepository) : ViewModel() {
    // Connect LiveData to current Profile info
    private val _userData: LiveData<UserData> = repository.userData

    // This shows entire contents of database
    // Casts Flow to LiveData for Observers
    val allUserData: LiveData<List<UserTable>> = repository.allUserData.asLiveData()

    // Singleton UserRepo
    private var mUserRepository: UserRepository = repository

    // Pass user's name to repository
//    fun setName(name: String) {
//        mUserRepository.setName(name)
//    }
//
    // Return data from LiveData obj
    val userData: LiveData<UserData>
        get() = _userData


    fun setUserData(name: String, loc: String, age: Int, sex: String, activityLvl: String, weight: Int, photo: Bitmap) {
        userData.value?.apply {
            user.name = name
            user.loc = loc
            user.age = age
            user.sex = sex
            user.activityLvl = activityLvl
            user.weight = weight
            user.photo = photo
        }
        mUserRepository.setUserData(userData)
    }

    fun setName(name: String) {
        _userData.value?.apply {
            user.name = name
        }
    }

    // Navigation Component getter and methods
    lateinit var navController: NavController
    fun navigateToHome() {
        navController.navigate(R.id.action_profileFragment_to_homeFragment)
    }
    fun navigateToProfile() {
        navController.navigate(R.id.action_homeFragment_to_profileFragment)
    }

    // This factory class allows us to define custom constructors for the view model
    class ComboViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ComboViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ComboViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}