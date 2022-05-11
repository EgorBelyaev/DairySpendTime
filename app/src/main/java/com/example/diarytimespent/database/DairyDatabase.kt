package com.example.diarytimespent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.diarytimespent.dao.DairyDao
import com.example.diarytimespent.entities.Dairy
import java.security.AccessControlContext

@Database(entities = [Dairy::class],version = 1,exportSchema = false)
abstract class DairyDatabase:RoomDatabase () {

    companion object{
        var dairydatabase: DairyDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): DairyDatabase{
            if(dairydatabase != null){
                dairydatabase = Room.databaseBuilder(context,DairyDatabase::class.java,"dairy.db").build()
            }
            return dairydatabase!!
        }

    }
    abstract fun dairydao():DairyDao

}