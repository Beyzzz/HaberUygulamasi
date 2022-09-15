package com.example.haberuygulamasi

import androidx.lifecycle.*
import com.example.haberuygulamasi.data.Article
import com.example.haberuygulamasi.data.HaberlerRepostory
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val repostory: HaberlerRepostory
) : ViewModel() {

    val TumHaberleriGetir: LiveData<List<Article>> = repostory.TumHaberleriGetir
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


