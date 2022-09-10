package com.example.haberuygulamasi.data

import com.example.haberuygulamasi.data.Article

data class Haberler(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)