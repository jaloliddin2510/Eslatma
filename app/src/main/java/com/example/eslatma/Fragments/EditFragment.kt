package com.example.eslatma.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController

import com.example.eslatma.Options.BaseFragment
import com.example.eslatma.Options.NoteApp
import com.example.eslatma.Options.NoteEntity
import com.example.eslatma.R
import com.example.eslatma.databinding.EditFragmentBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

class EditFragment : BaseFragment<EditFragmentBinding>() {

    private var noteId: Int? = null



    override fun getIBinding(): EditFragmentBinding {
        return EditFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
    }

//    override fun setup() {
//        println("setup")
//        setData()
//    }
//
//    override fun clicks() = with(binding) {
//        println("click")
//        backEditFragment.setOnClickListener {
//            findNavController().popBackStack()
//        }
//        editCheckTask.setOnClickListener {
//            editTask()
//        }
//    }
//
//    private fun setData(): Unit = with(binding) {
//        println("setData")
//        noteId = arguments?.getInt("noteId")
//        noteId?.let {
//            getById(noteId!!)?.let { note ->
//                etEditText.setText(note.title)
//                etDescText.setText(note.desc)
//            }
//        }
//    }
//
//
//    private fun editTask() {
//        println("editTask")
//        val title = binding.etEditText.text?.toString() ?: ""
//        val desc = binding.etDescText.text?.toString() ?: ""
//        val dateFormat: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
//        val calendar: Calendar = Calendar.getInstance()
//        val formatTime = dateFormat.format(calendar.time)
//        noteId?.let {
//            NoteApp.appDataBase.noteDao().itemUpdated(NoteEntity(it, title, desc, formatTime))
//        }
//        findNavController().popBackStack()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.edit_fragment, container, false)

        val toolbar = view.findViewById<Toolbar>(R.id.edit_toolbar)
        toolbar.inflateMenu(R.menu.edit_menu)

        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.delete_item -> {
                    println("onClick Delete")
                    noteId = arguments?.getInt("noteId")
                    noteId?.let {
                        println("onClick ID")
                        getById(noteId!!)?.let { note ->
                            println("onClick Note $note")
                            NoteApp.appDataBase.noteDao().itemDeleted(note)
                        }
                    }
                    findNavController().popBackStack()
                    true
                }

                R.id.share_item -> {

                    true
                }

                else -> false
            }
        }
        return view
    }

    private fun getById(id: Int) = NoteApp.appDataBase.noteDao().getNoteById(id)
}