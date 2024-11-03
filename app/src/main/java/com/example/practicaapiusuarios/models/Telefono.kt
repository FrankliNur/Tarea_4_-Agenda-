package com.example.practicaapiusuarios.models

data class Telefono(
    var id: Long? = null,
    var etiqueta: String, // Puede ser "Casa", "Trabajo", "Celular" o personalizado
    var numero: String
)

