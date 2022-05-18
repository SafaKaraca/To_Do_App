package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.adapter.IslerAdapter
import com.safakaraca.todoapp.databinding.FragmentAnasayfaBinding
import com.safakaraca.todoapp.entity.Isler
import com.safakaraca.todoapp.viewmodel.AnasayfaFragmentViewModel

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this


        tasarim.anasayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        val islerListesi = ArrayList<Isler>()

        val k1 = Isler(1,"Kitap Oku")
        val k2 = Isler(2,"Yemek Ye")
        val k3 = Isler(3,"Kotlin Çalış")
        islerListesi.add(k1)
        islerListesi.add(k2)
        islerListesi.add(k3)

        val adapter = IslerAdapter(requireContext(),islerListesi,viewModel)
        tasarim.islerAdapter = adapter


        return tasarim.root
    }

    fun fabTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.isKayitGecis)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel : AnasayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true

    }

}