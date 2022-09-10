package com.example.haberuygulamasi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.haberuygulamasi.data.HaberArticle

class FavoriAdapter(
    private var HaberlerListesi: List<HaberArticle>
) : RecyclerView.Adapter<FavoriAdapter.CardNesneleriniTut>() {

    inner class CardNesneleriniTut(view: View) : RecyclerView.ViewHolder(view) {
        var satirCardView2: CardView
        var haberImageView2: ImageView

        //var textViewHaberBaslık2 : TextView
        var buttonKaydet2: ImageButton
        var buttonFavori2: ImageView

        init {
            satirCardView2 = view.findViewById(R.id.satirCardView2)
            haberImageView2 = view.findViewById(R.id.haberImageView2)
            //textViewHaberBaslık2 = view.findViewById(R.id.textViewHaberBaslık2)
            buttonKaydet2 = view.findViewById(R.id.buttonKaydet2)
            buttonFavori2 = view.findViewById(R.id.favoriButton2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardNesneleriniTut {
        val tasarim = LayoutInflater.from(parent.context).inflate(R.layout.card_view2, parent)
        return CardNesneleriniTut(tasarim)

    }


    override fun getItemCount(): Int {
        return HaberlerListesi.size
    }


    fun setData(HaberlerListesi: List<HaberArticle>) {
        this.HaberlerListesi = HaberlerListesi
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CardNesneleriniTut, position: Int) {
        val haber = HaberlerListesi.get(position)
    }

}