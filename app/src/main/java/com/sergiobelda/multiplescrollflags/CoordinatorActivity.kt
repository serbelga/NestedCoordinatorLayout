package com.sergiobelda.multiplescrollflags

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergiobelda.multiplescrollflags.databinding.ActivityCoordinatorBinding
import com.sergiobelda.multiplescrollflags.dummy.DummyContent

class CoordinatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoordinatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MyItemRecyclerViewAdapter(DummyContent.ITEMS)
        }
    }
}