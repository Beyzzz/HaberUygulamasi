package com.example.haberuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.haberuygulamasi.data.ApiInterface
import com.example.haberuygulamasi.data.Article
import com.example.haberuygulamasi.data.Haberler
import kotlinx.android.synthetic.main.fragment_birinci.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BirinciFragment : Fragment() {


    private lateinit var myAdapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_birinci, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)
        getMyData()


    }

    fun getMyData() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofit.getHaber()
        retrofitData.enqueue(object : Callback<Haberler?> {
            override fun onResponse(call: Call<Haberler?>, response: Response<Haberler?>) {
                val responseBody = response.body()!!.articles


                myAdapter = MyAdapter(responseBody, ::onItemClick )
                rv.adapter = myAdapter
            }

            override fun onFailure(call: Call<Haberler?>, t: Throwable) {
                println("hata var")
            }

        })
    }

    fun onItemClick(article: Article) {
        Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
        findNavController().navigate(
            BirinciFragmentDirections.action(article.url)
        // BirinciFragmentDirections.webViewAction(article.url)
        )

    }


}









