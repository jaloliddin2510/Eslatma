package com.example.eslatma.Options

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("SELECT * FROM Notes")
    fun getAllNotes(): LiveData<List<NoteEntity>>
    @Insert
    fun insertNote(note: NoteEntity)

    @Delete
    fun itemDeleted(note: NoteEntity)

    @Update
    fun itemUpdated(note: NoteEntity)

    @Query( "SELECT * FROM Notes WHERE id = :id")
    fun getNoteById(id: Int): NoteEntity?

}