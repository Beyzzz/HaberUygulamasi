package com.example.haberuygulamasi.data

import androidx.lifecycle.LiveData

// view modelden erişebilmek için repostory oluşturmamız gerekir.
class HaberlerRepostory(private val daoInterface: ArticleDao) {

    val TumHaberleriGetir: LiveData<List<Article>> = daoInterface.TumHaberleriGetir()

    suspend fun HaberEkle(haberArticle: Article) {
        daoInterface.HaberEkle(haberArticle)
    }

    suspend fun HaberSil(haberArticle: Article) {
        daoInterface.HaberSil(haberArticle.title)
    }

    suspend fun favorriMi(article: Article): Boolean {
        val dbArticle = daoInterface.favorriMi(article.title)
        return dbArticle != null
    }


}