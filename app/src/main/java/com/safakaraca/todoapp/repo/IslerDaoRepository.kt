package com.safakaraca.todoapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.safakaraca.todoapp.entity.Isler

class IslerDaoRepository {

    var islerListesi: MutableLiveData<List<Isler>>

    init {
        islerListesi = MutableLiveData()
    }

    fun isleriGetir():MutableLiveData<List<Isler>>{
        return islerListesi
    }


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

    fun tumIsleriAl(){

        val liste = ArrayList<Isler>()

        val k1 = Isler(1,"Kitap Oku")
        val k2 = Isler(2,"Yemek Ye")
        val k3 = Isler(3,"Kotlin Çalış")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)
        islerListesi.value = liste

    }


}