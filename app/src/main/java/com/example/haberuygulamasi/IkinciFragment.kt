package com.example.haberuygulamasi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.haberuygulamasi.data.Article
import com.example.haberuygulamasi.data.HaberDatabase
import com.example.haberuygulamasi.data.HaberlerRepostory
import kotlinx.android.synthetic.main.fragment_ikinci.*

class IkinciFragment : Fragment(R.layout.fragment_ikinci) {

    private val adapter by lazy { ArticleAdapter(::onItemClick) }
    private lateinit var viewModel: FavouriteViewModel
    private val repository by lazy {
        HaberlerRepostory(HaberDatabase.getDataBase(requireContext()).getDaoInterface())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewFav.adapter = adapter
        viewModel = ViewModelProvider(
            this,
            FavouriteViewModelFactory(repository)
        ).get(FavouriteViewModel::class.java)
        viewModel.TumHaberleriGetir.observe(viewLifecycleOwner) { HaberlerListesi ->
            adapter.setData(HaberlerListesi)
            if (HaberlerListesi.isEmpty()) {
                Toast.makeText(context, "Liste boş", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun onItemClick(article: Article) {
        Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
        findNavController().navigate(
            IkinciFragmentDirections.actionIkinciFragmentToWebFragment(article)
        )
    } }
