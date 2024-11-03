package com.example.practicaapiusuarios.models


data class Contacto(
    var id: Long? = null,
    var nombre: String,
    var apellido: String,
    var empresa: String? = null,
    var direccion: String? = null,
    var ciudad: String? = null,
    var estado: String? = null,
    var telefonos: List<Telefono> = listOf(),
    var correos: List<Correo> = listOf(),
    var fotoPerfil: String? = null // URL o ruta de la imagen
)

typealias Contactos = ArrayList<Contacto>

