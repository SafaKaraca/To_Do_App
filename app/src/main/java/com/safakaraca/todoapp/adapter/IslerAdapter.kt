package com.safakaraca.todoapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.safakaraca.todoapp.R
import com.safakaraca.todoapp.databinding.CardTasarimBinding
import com.safakaraca.todoapp.databinding.FragmentAnasayfaBinding
import com.safakaraca.todoapp.entity.Isler
import com.safakaraca.todoapp.fragment.AnasayfaFragmentDirections
import com.safakaraca.todoapp.viewmodel.AnasayfaFragmentViewModel

class IslerAdapter(var mContext:Context,
                   var islerListesi:List<Isler>,
                   var viewModel:AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding =DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val is_nesne = islerListesi.get(position)
        val t = holder.tasarim

        t.isNesnesi = is_nesne

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${is_nesne.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG).setAction("Evet"){
                viewModel.sil(is_nesne.yapilacak_id)
            }.show()
        }

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.isDetayGecis(is_nesne)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return islerListesi.size
    }
}