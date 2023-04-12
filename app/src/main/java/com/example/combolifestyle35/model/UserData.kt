package com.example.combolifestyle35.model

class UserData {

    //Setters and Getters
    var userData: UserData? = null
    var profile = Profile()

    inner class Profile {
        var name: String? = null
    }
}