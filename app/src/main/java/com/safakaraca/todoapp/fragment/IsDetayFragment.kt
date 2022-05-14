package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentIsDetayBinding

class IsDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentIsDetayBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentIsDetayBinding.inflate(inflater, container, false)



        tasarim.toolbarIsDetay.title = "İş Detay"

        val bundle:IsDetayFragmentArgs by navArgs()
        val gelenIs = bundle.isNesne

        tasarim.editTextYapilacakIs.setText(gelenIs.yapilacak_is)

        tasarim.buttonGuncelle.setOnClickListener {
            val yapilacak_is = tasarim.editTextYapilacakIs.text.toString()

            guncelle(gelenIs.yapilacak_id,yapilacak_is)

        }

        return tasarim.root
    }

    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        Log.e("İş Güncelle","$yapilacak_id - $yapilacak_is")

    }

}