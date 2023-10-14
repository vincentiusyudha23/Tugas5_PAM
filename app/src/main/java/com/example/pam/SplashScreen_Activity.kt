package com.example.pam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.pam.databinding.ActivitySplashScreenBinding

class SplashScreen_Activity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding
    private lateinit var sm: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

       sm = SessionManager(this)

        Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null)
        Handler(Looper.getMainLooper()).postDelayed({

            if(sm.getStatusLogin()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }, 3000)
    }
}