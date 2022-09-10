package com.example.haberuygulamasi

import androidx.lifecycle.*
import com.example.haberuygulamasi.data.Article
import com.example.haberuygulamasi.data.HaberlerRepostory
import kotlinx.coroutines.launch

class WebViewModel(
    private val repostory: HaberlerRepostory
) : ViewModel() {

    // öncek ekradnan parametre olarak gelen haber
    var article: Article? = null
    // o haberin favori oluğ olmadığı bilgisi
    val favoriMi = MutableLiveData<Boolean>()


    // haberin favori olup olmadığını kontrol eden fonksion
    fun checkFavouritesStatus(){
        article ?: return
        viewModelScope.launch {
            favoriMi.value = repostory.favorriMi(article!!)
        }
    }

    // favroiye ekleme
    fun HaberEkle() {
        article ?: return
        viewModelScope.launch {
            repostory.HaberEkle(article!!)
            favoriMi.value = true
        }
    }

    // favoriden silme
    fun HaberSil() {
        article ?: return
        viewModelScope.launch {
            repostory.HaberSil(article!!)
            favoriMi.value = false
        }
    }
}


@Suppress("UNCHECKED_CAST")
class WebViewModelFactory constructor(private val repository: HaberlerRepostory): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(WebViewModel::class.java)) {
            WebViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}