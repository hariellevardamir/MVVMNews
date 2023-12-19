package com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.models

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)