package com.example.mytask.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytask.*
import kotlinx.android.synthetic.main.fragment_goal.id_button_add
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenterInstance.getNoteList("note",requireContext())

        id_button_add.setOnClickListener {
            presenterInstance.addNote(id_edittext_notes,id_listview_notes,requireContext())
        }

        presenterInstance.showNoteList(id_listview_notes,requireContext())

    }

    override fun onStop() {
        super.onStop()

        presenterInstance.saveNoteList(dataInstance.ListNotes ,"note",requireContext())

    }

}