package com.example.practicaapiusuarios.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaapiusuarios.databinding.UserItemLayoutBinding
import com.example.practicaapiusuarios.models.Contacto // Asegúrate de que tienes este modelo
import com.example.practicaapiusuarios.models.Contactos // Cambia a tu tipo de datos adecuado

class ContactoListAdapter(
    private var contactoList: Contactos // Cambia a la lista de contactos
) : RecyclerView.Adapter<ContactoListAdapter.ContactoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoItemViewHolder {
        return ContactoItemViewHolder(
            UserItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return contactoList.size
    }

    override fun onBindViewHolder(holder: ContactoItemViewHolder, position: Int) {
        val item = contactoList[position]
        holder.bind(item)
    }

    fun updateData(newList: Contactos) {
        this.contactoList = newList
        notifyDataSetChanged()
    }

    class ContactoItemViewHolder(binding: UserItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val lblNombre = binding.lblNombre
        private val lblApellido = binding.lblApellido
        private val lblEmpresa = binding.lblEmpresa
        private val lblTelefono = binding.lblTelefono
        private val lblEmail = binding.lblEmail

        fun bind(item: Contacto) {
            lblNombre.text = item.nombre
            lblApellido.text = item.apellido
            lblEmpresa.text = item.empresa

            // Mostrar el primer teléfono
            val primerTelefono = item.telefonos.firstOrNull() // Obtiene el primer teléfono si existe
            lblTelefono.text = primerTelefono?.numero ?: "No disponible" // Muestra "No disponible" si no hay teléfonos

            // Mostrar el primer correo
            val primerCorreo = item.correos.firstOrNull() // Obtiene el primer correo si existe
            lblEmail.text = primerCorreo?.correo ?: "No disponible" // Muestra "No disponible" si no hay correos
        }
    }

}
