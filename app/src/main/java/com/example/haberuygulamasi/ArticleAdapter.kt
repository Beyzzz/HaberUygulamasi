package com.example.haberuygulamasi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.haberuygulamasi.data.Article
import java.util.ArrayList

class ArticleAdapter(
    private val onClick: (Article) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private var HabelerList: List<Article> = ArrayList()
    inner class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var satirCardView: CardView
        var haberImageView: ImageView
        var textViewHaberBaslık: TextView
        var buttonKaydet: ImageButton
        var buttonFavori: ImageView
        init {
            satirCardView = view.findViewById(R.id.satirCardView2)
            haberImageView = view.findViewById(R.id.haberImageView)
            textViewHaberBaslık = view.findViewById(R.id.textViewHaberBaslık)
            buttonKaydet = view.findViewById(R.id.buttonKaydet)
            buttonFavori = view.findViewById(R.id.favoriButton)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val tasarim =
            LayoutInflater.from(parent.context).inflate(R.layout.card_tasarimi, parent, false)
        return ArticleViewHolder(tasarim)
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        // hangi veriyi hangi görsel nesneye aktaracağımızı belirtiyoruz
        Glide.with(holder.haberImageView.context).load(HabelerList[position].urlToImage)
            .into(holder.haberImageView)
        holder.textViewHaberBaslık.text = HabelerList[position].title
        holder.haberImageView.setOnClickListener {
            onClick(HabelerList[position])
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(list:List<Article>){
        this.HabelerList = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return HabelerList.size
    }

}
