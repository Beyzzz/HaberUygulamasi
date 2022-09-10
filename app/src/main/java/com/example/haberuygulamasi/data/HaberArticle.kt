package com.example.haberuygulamasi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "HaberArticle")
data class HaberArticle(@PrimaryKey(autoGenerate = false)
                        //@ColumnInfo(name = "author")@NotNull var author : String,
                        //@ColumnInfo(name = "content")@NotNull var content : String,
                        //@ColumnInfo(name = "description")@NotNull var description : String,
                        //@ColumnInfo(name = "publishedAt")@NotNull var publishedAt : String,
                        @ColumnInfo(name = "url")@NotNull var url : String,
                        @ColumnInfo(name = "title")@NotNull var title : String,
                        @ColumnInfo(name = "urlToImage")@NotNull var urlToImage : String
                       ){
}