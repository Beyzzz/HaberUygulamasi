package com.example.haberuygulamasi

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.navigation.fragment.navArgs


class WebFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: WebFragmentArgs by navArgs()
        val gelenUrl = bundle.url

        val webView = view.findViewById<WebView>(R.id.web)
        webView?.settings?.javaScriptEnabled = true
        webView?.loadUrl(gelenUrl)

    }

    private fun copyClipboard(url: String) {
        val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("link", url)
        clipboard?.setPrimaryClip(clip)
        Toast.makeText(context, "Link kopyalandı", Toast.LENGTH_SHORT).show()
    }
}

