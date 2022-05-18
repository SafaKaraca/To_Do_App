package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentIsDetayBinding
import com.safakaraca.todoapp.viewmodel.IsDetayFragmentViewModel

class IsDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentIsDetayBinding
    private lateinit var viewModel:IsDetayFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_is_detay, container, false)
        tasarim.isDetayFragment = this

        tasarim.isDetayToolbarBaslik = "İş Detay"

        val bundle:IsDetayFragmentArgs by navArgs()
        val gelenIs = bundle.isNesne
        tasarim.isNesnesi = gelenIs

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:IsDetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(yapilacak_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)

    }

}