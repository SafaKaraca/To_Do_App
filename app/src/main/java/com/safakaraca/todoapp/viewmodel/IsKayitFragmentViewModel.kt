package com.safakaraca.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.safakaraca.todoapp.repo.IslerDaoRepository

class IsKayitFragmentViewModel :ViewModel() {

    val krepo = IslerDaoRepository()

    fun kayit(yapilacak_is:String){
        krepo.isKayit(yapilacak_is)

    }
}