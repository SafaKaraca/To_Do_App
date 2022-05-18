package com.safakaraca.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.safakaraca.todoapp.repo.IslerDaoRepository

class IsDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val krepo = IslerDaoRepository(application)

    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        krepo.isGuncelle(yapilacak_id,yapilacak_is)

    }
}