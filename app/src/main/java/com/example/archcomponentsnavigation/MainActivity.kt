package com.example.archcomponentsnavigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNavigationSelected(@IdRes navigationId: Int, bundle: Bundle? = null) {
        navController.navigate(navigationId, bundle)
    }

    fun openNavigationDrawer() {
        val directions = when (val currentDestinationId = navController.currentDestination!!.id) {
            R.id.homeFragment -> {
                HomeFragmentDirections.actionHomeFragmentToNavigationFragment(currentDestinationId)
            }
            R.id.transactionsFragment -> {
                TransactionsFragmentDirections.actionTransactionsFragmentToNavigationFragment(currentDestinationId)
            }
            R.id.settingFragment -> {
                SettingFragmentDirections.actionSettingFragmentToNavigationFragment(currentDestinationId)
            }
            else -> throw IllegalArgumentException("$currentDestinationId can not open the navigation drawer.")
        }
        val navOptions = NavOptions.Builder()
            .setEnterAnim(android.R.anim.slide_in_left)
            .setExitAnim(android.R.anim.slide_out_right)
            .setPopEnterAnim(R.anim.slide_in_right)
            .setPopExitAnim(R.anim.slide_out_left)
            .build()

        navController.navigate(directions, navOptions)
    }

}
