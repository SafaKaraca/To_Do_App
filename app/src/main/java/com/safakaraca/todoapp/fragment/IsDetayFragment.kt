package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentIsDetayBinding

class IsDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentIsDetayBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_is_detay, container, false)
        tasarim.isDetayFragment = this

        tasarim.isDetayToolbarBaslik = "İş Detay"

        val bundle:IsDetayFragmentArgs by navArgs()
        val gelenIs = bundle.isNesne
        tasarim.isNesnesi = gelenIs

        return tasarim.root
    }

    fun buttonGuncelle(yapilacak_id:Int,yapilacak_is:String){
        Log.e("İş Güncelle","$yapilacak_id - $yapilacak_is")

    }

}