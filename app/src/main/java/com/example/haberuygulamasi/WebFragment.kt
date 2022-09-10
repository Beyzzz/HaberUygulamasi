package com.example.haberuygulamasi

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.haberuygulamasi.data.HaberDatabase
import com.example.haberuygulamasi.data.HaberlerRepostory
import kotlinx.android.synthetic.main.fragment_web.*


class WebFragment : Fragment(R.layout.fragment_web) {

    private val bundle: WebFragmentArgs by navArgs()
    private lateinit var viewModel: WebViewModel
    private val repository by lazy {
        HaberlerRepostory(HaberDatabase.getDataBase(requireContext()).getDaoInterface())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewModel oluşturmak için kullnaıyor
        viewModel = ViewModelProvider(
            this,
            WebViewModelFactory(repository)
        ).get(WebViewModel::class.java)
     //observele live dataları takip ettirmek, ekran açıkken takip eder kapalıysa bırakır
        viewModel.favoriMi.observe(viewLifecycleOwner) { isFav ->
            val icon = if (isFav) R.drawable.favori else R.drawable.favori_cerceve
            btnFav.setImageResource(icon)
        }

        viewModel.article = bundle.article
        viewModel.checkFavouritesStatus()
        // Haberin favori durumunu kontrol etmek

        web?.settings?.javaScriptEnabled = true
        web?.loadUrl(viewModel.article?.url ?: "")
        btnFav.setOnClickListener {
            if (viewModel.favoriMi.value == true) viewModel.HaberSil()
            else viewModel.HaberEkle()
        }
        btnCopy.setOnClickListener { 
            val url = viewModel.article?.url
            if (url.isNullOrBlank().not())
                copyClipboard(url!!)
        }

    }

    private fun copyClipboard(url: String) {
        val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("link", url)
        clipboard?.setPrimaryClip(clip)
        Toast.makeText(context, "Link kopyalandı", Toast.LENGTH_SHORT).show()
    }
}

