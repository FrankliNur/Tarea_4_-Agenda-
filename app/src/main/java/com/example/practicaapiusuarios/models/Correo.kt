package com.example.practicaapiusuarios.models

data class Correo(
    var id: Long? = null,
    var correo: String,
    var etiqueta: String // Puede ser "Persona", "Trabajo", "Universidad" o personalizado
)
