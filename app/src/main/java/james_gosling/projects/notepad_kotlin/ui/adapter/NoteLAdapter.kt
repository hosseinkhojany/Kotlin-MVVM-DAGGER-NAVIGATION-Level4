package james_gosling.projects.notepad_kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import james_gosling.projects.notepad_kotlin.R
import james_gosling.projects.notepad_kotlin.persistence.Note
import kotlinx.android.synthetic.main.note_items.view.*



class NoteAdapter(
    noteList: List<Note>,
    private val interaction: Interaction? = null
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val notes = mutableListOf<Note>()

    init {
        notes.addAll(noteList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_items, parent, false)
        return ViewHolder(
            view,
            interaction
        )
    }

    override fun getItemCount() = notes.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = notes[position])
    }


    fun swap(notes: List<Note>) {
        val diffCallback = DiffCallback(this.notes, notes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.notes.clear()
        this.notes.addAll(notes)
        diffResult.dispatchUpdatesTo(this)
    }


    class ViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Note) {
            itemView.txtTitle.text = item.title
            itemView.txtDescription.text = item.description
            itemView.txtTag.text = item.tag

            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition,item)
            }
        }

    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Note)
    }
}