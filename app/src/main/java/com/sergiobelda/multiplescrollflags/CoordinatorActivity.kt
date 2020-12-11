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
        // NOTE: when material-components for android fixes bug scrolling AppBarLayout we can remove
        // this block of code
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> {
                        if (!binding.recyclerView.canScrollVertically(-1)) {
                            binding.appbarLayout.setExpanded(true)
                        }
                    }
                }
            }
        })
    }
}