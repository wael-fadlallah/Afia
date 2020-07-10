package com.example.afia.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.afia.R
import kotlinx.android.synthetic.main.activity_dashboard.*


class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setupView()

    }

    private fun setupView() {
        var navController = findNavController(R.id.nav_fragment)

        navigation_bar.setupWithNavController(navController)
//        setupActionBarWithNavController(navController)
//        todo add action bar to show fragment label
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.app_action_bar,menu)
        menu?.getItem(0)?.setIcon(R.drawable.ic_profile_holder)
        return true
    }

}
