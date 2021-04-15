package com.example.myapplication

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteDataSource{

    @Inject
    lateinit var api: APIInterface

    init {
        DaggerAppComponent.builder().module(Module()).build().inject(this)
    }

    fun rxLogin(user:User): Single<LoginResponse> {
        return api.postLogin(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}