package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentIsDetayBinding
import com.safakaraca.todoapp.databinding.FragmentIsKayitBinding

class IsKayitFragment : Fragment() {

    private lateinit var tasarim: FragmentIsKayitBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentIsKayitBinding.inflate(inflater, container, false)


        tasarim.toolbarIsKayit.title = "İş Kayıt"

        tasarim.buttonKaydet.setOnClickListener {
            val yapılacak_is = tasarim.editTextYapilacakIs.text.toString()

            kayit(yapılacak_is)
        }

        return tasarim.root
    }

    fun kayit(yapilacak_is:String){
        Log.e("İş Kayıt" ,"$yapilacak_is")
    }

}