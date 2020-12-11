package com.sergiobelda.multiplescrollflags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergiobelda.multiplescrollflags.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.getLong("")
        binding.nestedCoordinator.setOnClickListener {
            startActivity(
                Intent(this, CoordinatorActivity::class.java)
            )
        }
        binding.motionLayout.setOnClickListener {
            startActivity(
                Intent(this, MotionLayoutNestedActivity::class.java)
            )
        }
    }
}