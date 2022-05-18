package com.safakaraca.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.safakaraca.todoapp.repo.IslerDaoRepository

class AnasayfaFragmentViewModel:ViewModel() {
    val krepo = IslerDaoRepository()

    fun ara(aramaKelimesi:String){
        krepo.isAra(aramaKelimesi)
    }

    fun sil(yapilacak_id:Int){
        krepo.isSil(yapilacak_id)

    }
}