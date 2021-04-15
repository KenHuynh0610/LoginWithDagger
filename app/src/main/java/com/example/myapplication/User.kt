package com.example.myapplication

data class User(var email: String, var password: String)

data class UserData(
    var _id: String,
    var name: String,
    var email: String,
    var password: String,
    var type: String

)

data class LoginResponse(var token: String, var user: UserData)