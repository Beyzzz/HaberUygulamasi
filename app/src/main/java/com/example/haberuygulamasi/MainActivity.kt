package com.example.haberuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{
    /*lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "NEWS"
        setSupportActionBar(toolbar)
        // Bottom navla navhost fragmentı bağlıyoruz
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNav,navHostFragment.navController)
        // bottom navigasyonumla navhost fragmentımı birleştiriyorum

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.webFragment) {
                bottomNav.visibility = View.GONE
                toolbar.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
                toolbar.visibility = View.VISIBLE
            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_arama,menu)
        val item = menu.findItem(R.id.actionAra)
        val searchView = item.actionView as SearchView
        // item ı arama sınıfından bir nesneye dönüştürdüm as diyerek
        searchView.setOnQueryTextListener(this)
        // Arama işlemini tetikledik.
        return super.onCreateOptionsMenu(menu)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        // Her har girdiğimde sonucu yazdırabilirim
        /*if (query != null) {
            Log.e("onQueryTextSubmit", query)
        }*/
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        /*if (newText != null) {
            Log.e("onQueryTextChange", newText)
        }*/
        return true
    }



}
