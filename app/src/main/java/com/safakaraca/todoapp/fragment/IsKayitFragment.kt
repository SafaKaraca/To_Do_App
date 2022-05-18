package com.safakaraca.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.FragmentIsDetayBinding
import com.safakaraca.todoapp.databinding.FragmentIsKayitBinding
import com.safakaraca.todoapp.viewmodel.IsKayitFragmentViewModel
import com.safakaraca.todoapp.viewmodel.IsKayitVMF

class IsKayitFragment : Fragment() {

    private lateinit var tasarim: FragmentIsKayitBinding
    private lateinit var viewModel: IsKayitFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_is_kayit, container, false)
        tasarim.isKayitFragment = this

        tasarim.isKayitToolbarBaslik = "İş Kayıt"
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:IsKayitFragmentViewModel by viewModels(){
            IsKayitVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(yapilacak_is:String){
        viewModel.kayit(yapilacak_is)
    }

}