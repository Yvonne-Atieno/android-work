package dev.yvonne.mycontactpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.contactapp.databinding.ActivityMainBinding
import dev.yvonne.mycontactpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        displayContact()
    }
    fun displayContact(){
        val contact1=contactData("","Yvonne","072740662314","Yvonne@gmail.com ")
        val contact2=contactData(" ","Cynthia","0740506060"," Cynthia@gmail.com")
        val contact3=contactData(" ","Mercy","07231426478","Mercy@gmail.com ")
        val contact4=contactData(" ","Emma","0789654321","Emma@gmail.com ")
        val contact5=contactData(" ","Emilly","0765431874"," Emily@gmail.com")
        val contactApp= listOf(contact1,contact2,contact3,contact4,contact5)
        val contactAdapter=ContactAdapter(contactApp)
        binding.rvRecycler.layoutManager=LinearLayoutManager(this)
        binding.rvRecycler.adapter=contactAdapter
    }
}