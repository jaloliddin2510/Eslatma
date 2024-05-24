package com.example.eslatma.Options

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        @Volatile
        private var INTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            return INTANCE ?: synchronized(this) {
                INTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, "database-name"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                return INTANCE!!
            }
        }
    }

    abstract fun noteDao(): NoteDao
}