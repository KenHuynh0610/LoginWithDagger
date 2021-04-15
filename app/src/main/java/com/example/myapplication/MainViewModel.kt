package com.example.myapplication

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject


class MainViewModel: ViewModel() {
    var email: String? = null
    var password: String? = null
    val loginStatus = MutableLiveData<LoginAction>()
    val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repo: Repository

    init {
        DaggerAppComponent.builder().module(Module()).build().inject(this)
    }

    enum class LoginAction(val message: String) {
        SUCCESS("Login Succeeded"),
        FAILURE("Login Failed"),
        MISSING_FIELD("Some Fields are missing")
    }

    fun onButtonClicked(view: View){
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            loginStatus.value = LoginAction.MISSING_FIELD
        } else {

            var user = User(email!!, password!!)

            compositeDisposable.add(
                repo.remoteDataSource.rxLogin(user)
                    .subscribe({ response -> onResponse(response) }, { t -> onFailure(t) })
            )
        }
    }
    private fun onResponse(response: LoginResponse) {
        loginStatus.value = LoginAction.SUCCESS
    }

    private fun onFailure(t: Throwable) {
        loginStatus.value = LoginAction.FAILURE
    }



}

