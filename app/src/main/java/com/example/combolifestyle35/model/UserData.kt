package com.example.combolifestyle35.model

class UserData {

    //Setters and Getters
    var userData: UserData? = null
    var user = User()

    inner class User {
        var name: String? = null
    }
}