package com.safakaraca.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.safakaraca.todoapp.repo.IslerDaoRepository

class IsDetayFragmentViewModel:ViewModel() {
    val krepo = IslerDaoRepository()

    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        krepo.isGuncelle(yapilacak_id,yapilacak_is)

    }
}