package dev.yvonne.mycontactpage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.example.contactapp.databinding.ContactListItemBinding
import dev.yvonne.mycontactpage.databinding.ContactListDataBinding

class ContactAdapter(var ContactData:List<contactData>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ContactData.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = ContactData.get(position)
        var binding = holder.binding
        binding.ivImage.tag = currentContact.avatar
        binding.tvDisplayName.text = currentContact.displayName
        binding.tvEmail.text = currentContact.email
        binding.tvPhoneNumber.text = currentContact.phoneNumber
    }

    class ContactViewHolder(var binding: ContactListDataBinding) : ViewHolder(binding.root)

}


