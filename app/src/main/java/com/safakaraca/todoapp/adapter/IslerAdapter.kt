package com.safakaraca.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.safakaraca.todoapp.databinding.CardTasarimBinding
import com.safakaraca.todoapp.databinding.FragmentAnasayfaBinding
import com.safakaraca.todoapp.entity.Isler

class IslerAdapter(var mContext:Context,var islerListesi:List<Isler>)
    : RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)


    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val is_nesne = islerListesi.get(position)
        val t = holder.tasarim
        t.textViewIsBilgi.setText("${is_nesne.yapilacak_is}")
    }

    override fun getItemCount(): Int {
        return islerListesi.size
    }
}