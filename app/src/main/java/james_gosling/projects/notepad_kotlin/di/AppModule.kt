package james_gosling.projects.notepad_kotlin.di

import android.app.Application
import androidx.room.Room
import james_gosling.projects.notepad_kotlin.persistence.NoteDao
import james_gosling.projects.notepad_kotlin.persistence.NoteDatabase
import james_gosling.projects.notepad_kotlin.repository.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {


    @Singleton
    @Provides
    fun providesAppDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(app,NoteDatabase::class.java,"note_database").build()
    }

    @Singleton
    @Provides
    fun providesNoteDao(db: NoteDatabase): NoteDao {
        return db.noteDao()
    }

    @Provides
    fun providesRepository(noteDao: NoteDao):NoteRepository{
        return NoteRepository(noteDao)
    }
}