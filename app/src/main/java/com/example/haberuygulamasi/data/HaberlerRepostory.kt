package com.example.haberuygulamasi.data

import androidx.lifecycle.LiveData

// view modelden erişebilmek için repostory oluşturmamız gerekir.
class HaberlerRepostory (private val daoInterface: DaoInterface){
      val TumHaberleriGetir : LiveData<List<HaberArticle>> = daoInterface.TumHaberleriGetir()
    suspend fun HaberEkle(haberArticle: HaberArticle){
        daoInterface.HaberEkle(haberArticle)
    }

    suspend fun HaberSil(haberArticle: HaberArticle){
        daoInterface.HaberSil(haberArticle)
    }



}