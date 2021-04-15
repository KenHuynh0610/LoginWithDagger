package com.example.myapplication

import javax.inject.Inject

class Repository{
    @Inject
    lateinit var remoteDataSource: RemoteDataSource

    init {
        DaggerAppComponent.builder().module(Module()).build().inject(this)
    }

}