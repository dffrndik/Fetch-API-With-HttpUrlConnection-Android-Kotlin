package com.example.lkskabmobile2021

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lkskabmobile2021.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity(){
    lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener{
            loginAction()
        }
    }
    fun loginAction(){
        val username = binding.textUsername.text.toString()
        val password = binding.textPassword.text.toString()
        lateinit var toast: Toast
        if (!(username == "admin" && password == "12345")){
            toast = Toast.makeText(this, "username and password is invalid", Toast.LENGTH_SHORT)
            toast.show()
            return
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}