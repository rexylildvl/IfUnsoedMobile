package com.unsoed.informatikamobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.informatikamobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()
        }
    private fun initNavigation() {
        binding.btnToPage2.setOnClickListener {
            startActivity(Intent(this, Halaman2Activity::class.java))
        }
    }
}