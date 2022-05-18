package com.safakaraca.todoapp.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "isler")
data class Isler(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "yapilacak_id") @NotNull var yapilacak_id:Int,
                 @ColumnInfo(name = "yapilacak_is") @NotNull var yapilacak_is:String) : Serializable{
}