package com.sergiobelda.multiplescrollflags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergiobelda.multiplescrollflags.databinding.ActivityMotionLayoutNestedBinding
import com.sergiobelda.multiplescrollflags.dummy.DummyContent
import kotlin.math.abs

class MotionLayoutNestedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMotionLayoutNestedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionLayoutNestedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MyItemRecyclerViewAdapter(DummyContent.ITEMS)
        }
        binding.floatingActionButton.setOnClickListener {
            binding.motionLayout.transitionToEnd()
        }
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    // Scroll up
                    // binding.motionLayout.transitionToEnd()
                }
                if (dy < 0) {
                    // Scroll down
                    // binding.motionLayout.transitionToStart()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    RecyclerView.SCROLL_STATE_DRAGGING -> {
                    }
                }
            }
        })
    }
}