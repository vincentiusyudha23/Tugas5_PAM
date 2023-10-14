package com.example.pam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pam.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sm : SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        sm = SessionManager(this)

        binding.btnRegister.setOnClickListener{
            val userName = binding.registerUsername.text.toString()
            val passWord = binding.registerPassword.text.toString()

            if (!userName.isNullOrEmpty() && !passWord.isNullOrEmpty()){
                sm.setDetails(userName,passWord)
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "UserName/Password Harus Diisi!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}