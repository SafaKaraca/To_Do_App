package com.safakaraca.todoapp.room

import androidx.room.*
import com.safakaraca.todoapp.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM isler")
    suspend fun tumIsler() : List<Isler>


    @Insert
    suspend fun isEkle(isNesne:Isler)

    @Update
    suspend fun isGuncelle(isNesne: Isler)

    @Delete
    suspend fun isSil(isNesne: Isler)

    @Query("SELECT * FROM isler WHERE yapilacak_is like '%' ||:aramaKelimesi || '%'")
    suspend fun isArama(aramaKelimesi:String) :List<Isler>
}