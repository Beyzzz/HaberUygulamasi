package com.example.haberuygulamasi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 1)
abstract class HaberDatabase : RoomDatabase(){
    abstract fun getDaoInterface() : ArticleDao
    companion object{
        private var INSTANCE:
                HaberDatabase?=null
        fun getDataBase(context : Context):
                HaberDatabase {
            if(INSTANCE ==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, HaberDatabase::class.java,"haber_database").build()
                }
            }
            return INSTANCE!!
        }
    }
}