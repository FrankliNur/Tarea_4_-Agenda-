package com.example.practicaapiusuarios.ui.activities

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaapiusuarios.databinding.ActivityMainBinding
import com.example.practicaapiusuarios.ui.adapters.ContactoListAdapter
import com.example.practicaapiusuarios.ui.viewmodels.ContactoViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ContactoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupEventListeners()
        setupViewModelObservers()
        viewModel.loadContacts()
    }

    private fun setupEventListeners() {
        binding.fabAddUser.setOnClickListener {
            // Lógica para abrir un formulario de nuevo contacto
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Lógica para buscar contactos
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Lógica para filtrar la lista de contactos
                return true
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvUserList.apply {
            adapter = ContactoListAdapter(arrayListOf()) // Cambia a ContactoListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupViewModelObservers() {
        viewModel.contactList.observe(this) {
            val adapter = binding.rvUserList.adapter as ContactoListAdapter // Cambia a ContactoListAdapter
            adapter.updateData(it)
        }
    }
}
