package com.example.haberuygulamasi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {

    @Query("SELECT * FROM HaberArticle")
    fun TumHaberleriGetir(): LiveData<List<Article>>

    @Insert
    suspend fun HaberEkle(haberArticle: Article)

    @Query("DELETE FROM haberarticle WHERE title=:title")
    suspend fun HaberSil(title: String?)

    // aynı ismimde favori haber var ise o haber favoridir yoksa favori değildir
    @Query("SELECT * FROM HaberArticle WHERE title=:title")
    suspend fun favorriMi(title: String?): Article?
}
