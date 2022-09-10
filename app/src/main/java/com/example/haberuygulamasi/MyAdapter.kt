package com.example.haberuygulamasi

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
import com.example.haberuygulamasi.data.HaberArticle

class MyAdapter(private val HabelerList : List<Article>, private val onClick:(Article)-> Unit)
    : RecyclerView.Adapter<MyAdapter.cartViewNesneleriniTut> (){
    lateinit var viewModel: ViewModel
    lateinit var haberArticle: HaberArticle
    inner class cartViewNesneleriniTut(view: View): RecyclerView.ViewHolder(view){
        var satirCardView : CardView
        var haberImageView : ImageView
        var textViewHaberBaslık : TextView
        var buttonKaydet : ImageButton
        var buttonFavori : ImageView

        init {
            satirCardView = view.findViewById(R.id.satirCardView2)
            haberImageView= view.findViewById(R.id.haberImageView)
            textViewHaberBaslık = view.findViewById(R.id.textViewHaberBaslık)
            buttonKaydet = view.findViewById(R.id.buttonKaydet)
            buttonFavori = view.findViewById(R.id.favoriButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartViewNesneleriniTut {
        val tasarim = LayoutInflater.from(parent.context).inflate(R.layout.card_tasarimi, parent)
            return cartViewNesneleriniTut(tasarim)
    }

    override fun onBindViewHolder(holder: cartViewNesneleriniTut, position: Int) {
        // hangi veriyi hangi görsel nesneye aktaracağımızı belirtiyoruz
        Glide.with(holder.haberImageView.context).load(HabelerList[position].urlToImage).into(holder.haberImageView)
        holder.textViewHaberBaslık.text = HabelerList[position].title
        holder.haberImageView.setOnClickListener {
            onClick(HabelerList[position])
            //println(HabelerList[0].url)
        }
            val url = (HabelerList[position].url)
            holder.buttonFavori.setOnClickListener {
            viewModel.HaberEkle(haberArticle)
                println(viewModel.TumHaberleriGetir)
            }

            //println
            /*
            val gecis = BirinciFragmentDirections.webViewAction(url)
            Navigation.findNavController(it).navigate(gecis)

             */




        }



    override fun getItemCount(): Int {
         return HabelerList.size
    }

}
