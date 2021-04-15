package com.example.myapplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(Module::class))
interface AppComponent {

    fun inject(viewModel: MainViewModel)
    fun inject(remote: RemoteDataSource)
    fun inject(repo: Repository)
    fun inject(activity: MainActivity)
}