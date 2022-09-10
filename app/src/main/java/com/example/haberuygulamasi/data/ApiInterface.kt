package com.example.haberuygulamasi.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("top-headlines?country=tr&apiKey=bc0ec4760fd04507bb7cd894ec7b0dd2")
    fun getHaber() : Call<Haberler>
}
