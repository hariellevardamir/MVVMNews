package com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.databinding.ActivityNewsBinding
import com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.repository.NewsRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private lateinit var bottomNavigationMenu: BottomNavigationView
    private lateinit var navController: NavController

    val viewModel: NewsViewModel by lazy {
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setTheme(R.style.AppTheme)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.newsNavHostFragment)
        bottomNavigationMenu = binding.bottomNavigationView

        // viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        NavigationUI.setupWithNavController(bottomNavigationMenu, navController)

    }
}
