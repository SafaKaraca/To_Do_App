package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentIsDetayBinding
import com.safakaraca.todoapp.databinding.FragmentIsKayitBinding

class IsKayitFragment : Fragment() {

    private lateinit var tasarim: FragmentIsKayitBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_is_kayit, container, false)
        tasarim.isKayitFragment = this

        tasarim.isKayitToolbarBaslik = "İş Kayıt"
        return tasarim.root
    }

    fun buttonKaydetTikla(yapilacak_is:String){
        Log.e("İş Kayıt" ,"$yapilacak_is")
    }

}