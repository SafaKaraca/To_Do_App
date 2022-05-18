package com.safakaraca.todoapp.repo

import android.util.Log

class IslerDaoRepository {


    fun isKayit(yapilacak_is:String){
        Log.e("İş Kayıt" ,"$yapilacak_is")
    }

    fun isGuncelle(yapilacak_id:Int,yapilacak_is:String){
        Log.e("İş Güncelle" ,"$yapilacak_id - $yapilacak_is")
    }

    fun isAra(aramaKelimesi:String){
        Log.e("İş Ara",aramaKelimesi)
    }

    fun isSil(yapilacak_id:Int){
        Log.e("İş sil",yapilacak_id.toString())

    }


}