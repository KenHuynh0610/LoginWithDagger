package com.example.myapplication

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.Module

@Module
class Module {


    @Singleton
    @Provides
    fun providesContext(myApp: MyApp): Context = myApp.applicationContext

    @Singleton
    @Provides
    fun gsonFactoryProvider(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun getApi(retrofit: Retrofit): APIInterface {
        return retrofit.create(APIInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteRepository(): RemoteDataSource {
        return RemoteDataSource()
    }

    @Singleton
    @Provides
    fun provideUserRepository(): Repository {
        return Repository()
    }


    @Singleton
    @Provides
    fun rxJavaFactoryProvider(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun retrofitProvider(gson: GsonConverterFactory, rxJava: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addCallAdapterFactory(rxJava)
            .addConverterFactory(gson).build()
    }
}