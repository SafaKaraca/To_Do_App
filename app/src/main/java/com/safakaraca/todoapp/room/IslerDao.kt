package com.safakaraca.todoapp.room

import androidx.room.Dao
import androidx.room.Query
import com.safakaraca.todoapp.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM isler")
    suspend fun tumIsler() : List<Isler>
}