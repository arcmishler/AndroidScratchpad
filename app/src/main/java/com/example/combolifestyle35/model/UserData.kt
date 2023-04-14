package com.example.combolifestyle35.model

import android.graphics.Bitmap

class UserData {
    //Setters and Getters
    var userData: UserData? = null
    var user = User()

    inner class User {
        var id: Int? = null
        var name: String? = null
        var loc: String? = null
        var age: Int? = 0
        var sex: String? = null
        var activityLvl: String? = null
        var weight: Int? = 0
        var photo: Bitmap? = null
    }
}