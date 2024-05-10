package com.example.task6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task6.data.Data
import com.example.task6.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.NonCancellable.cancel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.run {
        }


        viewInit()
    }




    private fun viewInit() {
        val tabLayout = binding.tlTabs
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(this)

        // tab layout 과 view pager2 연동하는 코드
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setText("검색")
                    tab.setIcon(R.drawable.search_icon)
                }
                1 -> {
                    tab.setText("내 보관함")
                    tab.setIcon(R.drawable.folder_icon)
                }
            }
        }.attach()
    }


}