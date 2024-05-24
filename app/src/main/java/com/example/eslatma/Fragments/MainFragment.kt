package com.example.eslatma.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.eslatma.Options.Adapter
import com.example.eslatma.Options.BaseFragment
import com.example.eslatma.Options.NoteApp
import com.example.eslatma.R
import com.example.eslatma.databinding.MainFragmentBinding


@Suppress("NAME_SHADOWING")
class MainFragment : BaseFragment<MainFragmentBinding>() {

    private val mainAdapter by lazy {
        Adapter {
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.main_fragment,container,false)
        val toolbar=view.findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {item->
            when(item.itemId){
                R.id.pin_code->{


                    true
                }

                else -> {false}
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun getIBinding(): MainFragmentBinding {
        return MainFragmentBinding.inflate(layoutInflater)
    }

    override fun setup() {
        setupRV()
        setupObserver()
    }

    private fun setupObserver() {
        NoteApp.appDataBase.noteDao().getAllNotes().observe(viewLifecycleOwner) {
            mainAdapter.submitList(it)
        }
    }
    private fun setupRV() {
        binding.mainRecycler.adapter = mainAdapter
        mainAdapter.onLongClickListener = { noteId ->
            findNavController().navigate(R.id.action_mainFragment_to_editFragment, bundleOf("noteId" to noteId.id))

        }
    }

    override fun clicks() = with(binding) {
        addTask.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }
        mainToolbar.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pinFragment)
        }

    }
}