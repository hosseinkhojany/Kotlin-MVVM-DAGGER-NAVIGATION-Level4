package james_gosling.projects.notepad_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import james_gosling.projects.notepad_kotlin.R
import james_gosling.projects.notepad_kotlin.persistence.Note
import james_gosling.projects.notepad_kotlin.util.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add.*
import javax.inject.Inject


class AddFragment : DaggerFragment() {

    @Inject
    lateinit var viewmodelProviderFactory: ViewModelProviderFactory

    lateinit var noteViewModel: NoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

        btnAdd.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.container).popBackStack()
        }
    }

    private fun saveNoteToDatabase() {

        (activity as MainActivity?)?.showFloatingButton()

        if (validations()) {
            Toast.makeText(activity, "Note is saved", Toast.LENGTH_SHORT).show()
            saveNote()
        } else
            Toast.makeText(activity, "Note is Discarded", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveNoteToDatabase()
    }


    private fun saveNote() {
        val note = Note(0,addTitle.text.toString(),addDescription.text.toString(),addTag.text.toString())

        if (addTitle.text.isNullOrEmpty()) {
           note.title = "Empty Title"

            noteViewModel.insert(note)

        }else{
            noteViewModel.insert(note)
        }
    }

    fun validations(): Boolean {
        return !(addTitle.text.isNullOrEmpty()
                && addDescription.text.isNullOrEmpty()
                && addTag.text.isNullOrEmpty())
    }


    private fun setupViewModel() {
        noteViewModel = ViewModelProvider(this,viewmodelProviderFactory).get(NoteViewModel::class.java)
    }
}