package com.example.haberuygulamasi.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoInterface {
    // Database işlemlerini gerçekleştiriyoruz.
    @Query(value =  "SELECT * FROM HaberArticle")
     fun TumHaberleriGetir()  : LiveData<List<HaberArticle>>
    @Insert
    suspend fun HaberEkle(haberArticle: HaberArticle)
    @Delete
    suspend fun HaberSil(haberArticle: HaberArticle)

}