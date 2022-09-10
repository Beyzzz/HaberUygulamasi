package com.example.haberuygulamasi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.haberuygulamasi.data.HaberArticle
import com.example.haberuygulamasi.data.HaberDatabase
import com.example.haberuygulamasi.data.HaberlerRepostory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {
    val TumHaberleriGetir: LiveData<List<HaberArticle>>
    private val repostory: HaberlerRepostory


    init {
        val daoInterface = HaberDatabase.getDataBase(application).getDaoInterface()
        repostory = HaberlerRepostory(daoInterface)
        TumHaberleriGetir = daoInterface.TumHaberleriGetir()
    }

    fun HaberEkle(haberArticle: HaberArticle) {
        viewModelScope.launch(Dispatchers.IO) {
            repostory.HaberEkle(haberArticle)
        }

    }

    fun HaberSil(haberArticle: HaberArticle) {
        viewModelScope.launch(Dispatchers.IO) {
            repostory.HaberSil(haberArticle)
        }


    }
}