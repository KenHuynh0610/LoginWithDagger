package com.example.myapplication

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {
    @POST(Config.LOGIN_URL)
    fun postLogin(@Body user:User): Single<LoginResponse>
}