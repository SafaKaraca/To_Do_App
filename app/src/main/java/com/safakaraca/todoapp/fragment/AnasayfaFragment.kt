package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentAnasayfaBinding
import com.safakaraca.todoapp.entity.Isler

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var tasarim: FragmentAnasayfaBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)


        tasarim.toolbarAnasayfa.title = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.isKayitGecis)
        }

        tasarim.buttonDetay.setOnClickListener {
            val is_nesne = Isler(1,"iş yap")
            val gecis = AnasayfaFragmentDirections.isDetayGecis(is_nesne)
            Navigation.findNavController(it).navigate(gecis)
        }



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true

    }

    fun ara(aramaKelimesi:String){
        Log.e("İş ara", aramaKelimesi)
    }


}