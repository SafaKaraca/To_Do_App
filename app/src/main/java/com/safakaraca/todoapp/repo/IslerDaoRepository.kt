package com.safakaraca.todoapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.safakaraca.todoapp.entity.Isler
import com.safakaraca.todoapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Appendable

class IslerDaoRepository(var application: Application) {

    var islerListesi: MutableLiveData<List<Isler>>
    var vt:Veritabani

    init {
        islerListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun isleriGetir():MutableLiveData<List<Isler>>{
        return islerListesi
    }

    fun isKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniIs = Isler(0,yapilacak_is)
            vt.IslerDao().isEkle(yeniIs)
        }
    }

    fun isGuncelle(yapilacak_id:Int,yapilacak_is:String){
        val job =  CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Isler(yapilacak_id,yapilacak_is)
            vt.IslerDao().isGuncelle(guncellenenIs)
        }
    }

    fun isAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.IslerDao().isArama(aramaKelimesi)
        }
    }

    fun isSil(yapilacak_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Isler(yapilacak_id,"")
            vt.IslerDao().isSil(silinenIs)
            tumIsleriAl()
        }
    }

    fun tumIsleriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.IslerDao().tumIsler()
        }

    }


}