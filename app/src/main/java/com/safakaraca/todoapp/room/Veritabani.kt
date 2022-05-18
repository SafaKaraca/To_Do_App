package com.safakaraca.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.safakaraca.todoapp.entity.Isler

@Database(entities = [Isler::class], version = 1)
abstract class Veritabani :RoomDatabase() {
    abstract fun IslerDao() : IslerDao

    companion object {
        var INSTANCE:Veritabani? = null

        fun veritabaniErisim(context : Context) : Veritabani?{
            if(INSTANCE == null){
                synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,Veritabani::class.java,"isler.db").createFromAsset("isler.db").build()
                }
            }
            return INSTANCE

        }
    }
}