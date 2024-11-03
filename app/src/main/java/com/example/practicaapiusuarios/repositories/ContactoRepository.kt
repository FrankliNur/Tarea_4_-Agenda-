package com.example.practicaapiusuarios.repositories


import com.example.practicaapiusuarios.api.ContactosApiService
import com.example.practicaapiusuarios.models.Contacto
import com.example.practicaapiusuarios.models.Contactos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ContactoRepository {
    fun getContactList(onSuccess: (Contactos) -> Unit, onError: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getRetrofitInstance()
        val service = retrofit.create(ContactosApiService::class.java)
        service.getContactList().enqueue(object : Callback<Contactos> {
            override fun onResponse(call: Call<Contactos>, response: Response<Contactos>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(Throwable("Error en la respuesta"))
                }
            }

            override fun onFailure(call: Call<Contactos>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun createContact(contacto: Contacto, onSuccess: (Contacto) -> Unit, onError: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getRetrofitInstance()
        val service = retrofit.create(ContactosApiService::class.java)
        service.createContact(contacto).enqueue(object : Callback<Contacto> {
            override fun onResponse(call: Call<Contacto>, response: Response<Contacto>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(Throwable("Error en la respuesta"))
                }
            }

            override fun onFailure(call: Call<Contacto>, t: Throwable) {
                onError(t)
            }
        })
    }

    // Implementa métodos para actualizar y eliminar contactos...
}
