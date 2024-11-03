package com.example.practicaapiusuarios.api

import com.example.practicaapiusuarios.models.Contacto
import com.example.practicaapiusuarios.models.Contactos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ContactosApiService {
    @GET("/personas")
    fun getContactList(): Call<Contactos>

    @POST("/personas")
    fun createContact(@Body contacto: Contacto): Call<Contacto>

    @PUT("/personas/{id}")
    fun updateContact(@Path("id") id: Long, @Body contacto: Contacto): Call<Contacto>

    @DELETE("/personas/{id}")
    fun deleteContact(@Path("id") id: Long): Call<Void>
}

