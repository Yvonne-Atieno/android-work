package dev.yvonne.mycontactpage

import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
//import com.example.contactapp.databinding.ContactListItemBinding
import dev.yvonne.mycontactpage.databinding.ContactListDataBinding
import jp.wasabeef.picasso.transformations.CropCircleTransformation

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
        binding.tvbutton.setOnClickListener {
            val intent = Intent(holder.itemView.context, MainActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
        Picasso
            .get()
            .load(currentContact.avatar)
            .resize(40,40)
            .centerCrop(Gravity.CENTER)
            .transform(CropCircleTransformation())
            .into(binding.ivImage)
    }

    class ContactViewHolder(var binding: ContactListDataBinding) : ViewHolder(binding.root)

}


