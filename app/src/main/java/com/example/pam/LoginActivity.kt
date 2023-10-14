package com.example.pam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pam.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var sm : SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        sm = SessionManager(this)

        binding.tvSignup.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener{
            val name = binding.editTextText.text.toString()
            val pass = binding.editTextTextPassword.text.toString()
            var currentuser = arrayListOf<String>()
            if (!name.isNullOrEmpty() && !pass.isNullOrEmpty()){
                currentuser.add(name)
                currentuser.add(pass)
                validationUser(currentuser)
            } else {
                Toast.makeText(this, "Isikan Username/Password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validationUser(_currentuser: ArrayList<String>) {
        val user = sm.getRememberUser()

        if (user[0] == _currentuser[0] && user[1] == _currentuser[1]){
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
            sm.setStatusLogin(true)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Invalid Username/Password", Toast.LENGTH_SHORT).show()
        }
    }
}