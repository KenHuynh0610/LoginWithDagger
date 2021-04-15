package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        loginBinding.viewModel = viewModel

        viewModel.loginStatus.observe(this, Observer {
            if (it == MainViewModel.LoginAction.SUCCESS) {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
            } else {
                textViewError.text = it.message
            }
        })
    }
}