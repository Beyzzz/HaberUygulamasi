package com.example.haberuygulamasi.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.haberuygulamasi.FavoriAdapter
import com.example.haberuygulamasi.R
import com.example.haberuygulamasi.ViewModel

class IkinciFragment : Fragment() {
  private lateinit var favoriAdapter: FavoriAdapter
  private lateinit var viewModel : ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ikinci, container, false)
        viewModel = ViewModelProvider(this).get(androidx.lifecycle.ViewModel::class.java) as ViewModel
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFav)
        viewModel.TumHaberleriGetir.observe(viewLifecycleOwner, Observer {
            HaberlerListesi-> favoriAdapter.setData(HaberlerListesi)
            if(HaberlerListesi.size== 0){
                Toast.makeText(context, "Liste boş", Toast.LENGTH_LONG).show()
            }

        })

      return view
    }


}