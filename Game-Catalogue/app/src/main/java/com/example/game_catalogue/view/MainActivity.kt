package com.example.game_catalogue.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.ActivityMainBinding
import com.example.game_catalogue.view.Fragment.CategoryListFragment
import com.example.game_catalogue.view.Fragment.FavouritesFragment
import com.example.game_catalogue.view.Fragment.GameListFragment
import com.example.game_catalogue.view.Fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.gameListFragment, R.id.categoryListFragment, R.id.favouritesFragment)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.gameListFragment) {
                navController.navigate(it.itemId, bundleOf(GameListFragment.ARG_MODE to 0))
            } else {
                navController.navigate(it.itemId)
            }
            true
        }
    }
}