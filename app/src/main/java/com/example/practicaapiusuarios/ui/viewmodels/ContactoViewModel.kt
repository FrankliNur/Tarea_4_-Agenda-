package com.example.practicaapiusuarios.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicaapiusuarios.models.Contacto
import com.example.practicaapiusuarios.models.Contactos
import com.example.practicaapiusuarios.repositories.ContactoRepository


class ContactoViewModel : ViewModel() {
    private val _contactList = MutableLiveData<Contactos>().apply {
        value = arrayListOf()
    }
    val contactList: LiveData<Contactos> = _contactList

    fun loadContacts() {
        ContactoRepository.getContactList(
            onSuccess = {
                _contactList.value = it
            }, onError = {
                it.printStackTrace()
            }
        )
    }

    fun addContact(contacto: Contacto) {
        ContactoRepository.createContact(contacto,
            onSuccess = {
                loadContacts()
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    // Implementa métodos para actualizar y eliminar contactos...
}
