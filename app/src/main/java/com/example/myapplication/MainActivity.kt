package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navController: NavController
        get() = findNavController(R.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(fragmentNavigationListener)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private val fragmentNavigationListener = NavController.OnDestinationChangedListener { _, destination, arguments ->
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            show()
        }

        when(destination.id) {
            R.id.destinationFragment -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }

            R.id.dispatchFragment -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }
}