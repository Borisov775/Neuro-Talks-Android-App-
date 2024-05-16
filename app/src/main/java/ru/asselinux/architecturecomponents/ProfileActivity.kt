package ru.asselinux.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name_of_user: TextView = findViewById(R.id.Name)
        val email_cred: TextView = findViewById(R.id.email_cred)
        val researchArea:TextView=findViewById(R.id.researchArea)
        val bio:TextView=findViewById(R.id.bio)


    }
}