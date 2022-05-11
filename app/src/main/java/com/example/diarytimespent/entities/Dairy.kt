package com.example.diarytimespent.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Dairy")
 class Dairy: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "currentMS")
    var currentMs: String? = null

    @ColumnInfo(name = "descriptions")
    var descriptions: String? = null

    @ColumnInfo(name = "isStarted")
    var isStarted: Boolean? = null

    override fun toString(): String {
        return "$currentMs: $descriptions"
    }
}