package com.example.haberuygulamasi

import android.app.Application
import androidx.lifecycle.*
import com.example.haberuygulamasi.data.Article
import com.example.haberuygulamasi.data.HaberArticle
import com.example.haberuygulamasi.data.HaberDatabase
import com.example.haberuygulamasi.data.HaberlerRepostory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val repostory: HaberlerRepostory
) : ViewModel() {

    val TumHaberleriGetir: LiveData<List<Article>> = repostory.TumHaberleriGetir

    fun HaberEkle(haberArticle: Article) {
        viewModelScope.launch {
            repostory.HaberEkle(haberArticle)
        }
    }

    fun HaberSil(haberArticle: Article) {
        viewModelScope.launch {
            repostory.HaberSil(haberArticle)
        }
    }
}


@Suppress("UNCHECKED_CAST")
class FavouriteViewModelFactory constructor(private val repository: HaberlerRepostory): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FavouriteViewModel::class.java)) {
            FavouriteViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}