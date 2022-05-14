package com.safakaraca.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentAnasayfaBinding
import com.safakaraca.todoapp.entity.Isler

class AnasayfaFragment : Fragment() {

    private lateinit var tasarim: FragmentAnasayfaBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)


        tasarim.toolbarAnasayfa.title = "Yapılacaklar"

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

}