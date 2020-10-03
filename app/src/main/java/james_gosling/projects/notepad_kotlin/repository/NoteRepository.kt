package james_gosling.projects.notepad_kotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import james_gosling.projects.notepad_kotlin.persistence.NoteDao
import james_gosling.projects.notepad_kotlin.persistence.Note
import kotlinx.coroutines.*
import javax.inject.Inject

class NoteRepository @Inject constructor(val noteDao: NoteDao) {

    fun insert(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insert(note)
        }
    }

    fun delete(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.delete(note)
        }
    }

    fun deleteById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.deleteById(id)
        }
    }

    fun update(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.update(note)
            Log.e("DEBUG", "update is called in repo")

        }
    }

    fun getAllNotes(): LiveData<List<Note>>{
        return noteDao.getAllNotes()
    }
}