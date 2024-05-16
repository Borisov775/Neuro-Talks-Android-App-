package ru.asselinux.architecturecomponents

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.hdodenhof.circleimageview.CircleImageView
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.room.ItemViewModel


class MainActivity : AppCompatActivity() {
    private val itemViewModel: ItemViewModel by viewModels()

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(false)
        val adapter = ItemAdapter(this@MainActivity)
        recyclerView.adapter = adapter
        val bottomNavigation:BottomNavigationView=findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    recreate()

                }
                R.id.post_button -> {

                    startActivity(Intent(this@MainActivity, addPostActivity::class.java))
                }
                R.id.profile_button->{
                    startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                }
            }
        }






        adapter.setOnItemClickListener(object :
            ItemAdapter.OnItemClickListener {
            override fun onItemClick(item: Item?) {
                if (item != null) {
                    val intent = Intent(this@MainActivity, PostActivity::class.java).putExtra("post",item)
                    startActivity(intent)
                }
            }
        })


        itemViewModel.allItems.observe(
            this, object : Observer<List<Item>> {
                override fun onChanged(
                    items: List<Item>
                ) {
                    adapter.setItems(items);
                }
            })
    }




    companion object {
        const val ADD_ITEM_REQUEST = 1
        const val EDIT_ITEM_REQUEST = 2
    }
}