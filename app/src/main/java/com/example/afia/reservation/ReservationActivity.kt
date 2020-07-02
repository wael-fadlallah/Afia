package com.example.afia.reservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.afia.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_reservation.*

class ReservationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

//        init tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("تفاصيل المريض"))
        tabLayout.addTab(tabLayout.newTab().setText("اختيار طبيب"))
        tabLayout.addTab(tabLayout.newTab().setText("تاريخ الحجز"))
        tabLayout.addTab(tabLayout.newTab().setText("الدفع"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val defaulTabItem = tabLayout.getTabAt(0)!!.select()

//      init view pager
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        tabLayout.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
        } )

    }
}
