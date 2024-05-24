package com.example.eslatma.Fragments

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.eslatma.Options.BaseFragment
import com.example.eslatma.Options.NoteApp
import com.example.eslatma.Options.NoteEntity
import com.example.eslatma.databinding.AddFragmentBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

class AddFragment : BaseFragment<AddFragmentBinding>() {
    override fun getIBinding(): AddFragmentBinding {
        return AddFragmentBinding.inflate(layoutInflater)
    }

    override fun clicks() {
        super.clicks()
        binding.backAddFragment.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.checkTask.setOnClickListener {
            addTask()
        }

    }

    @SuppressLint("SimpleDateFormat")
    private fun addTask() {
        val title = binding.etTask.text?.toString()?:""
        val desc = binding.addDesc.text?.toString()?:""
        val dataFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val calendar: Calendar = Calendar.getInstance()
        val formattedDataBase = dataFormat.format(calendar.time)
        Toast.makeText(this@AddFragment.requireContext(), "addTask", Toast.LENGTH_SHORT).show()
        val note=NoteEntity(title=title,desc=desc, formattedTime =formattedDataBase)
        NoteApp.appDataBase.noteDao().insertNote(note=note)
        findNavController().popBackStack()
    }
}