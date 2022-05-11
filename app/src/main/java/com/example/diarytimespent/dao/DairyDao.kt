package com.example.diarytimespent.dao

import androidx.room.*
import com.example.diarytimespent.entities.Dairy

@Dao
interface DairyDao {

    @get:Query("SELECT * FROM dairy ORDER BY id DESC ")
    val allDairy:List<Dairy>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDairy(dairy:Dairy)

    @Delete
    suspend fun deleteDairy(dairy: Dairy)

}