package ru.asselinux.architecturecomponents

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import ru.asselinux.architecturecomponents.R.id.btnPost
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.room.ItemViewModel
import java.time.Instant
import java.time.LocalDate
import java.util.Date

class addPostActivity:AppCompatActivity() {
    private val itemViewModel: ItemViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_post_activity)


        val headerEdit = findViewById<TextInputLayout>(R.id.header_edit)
        val profArea=findViewById<TextInputLayout>(R.id.preview_text)
        val profArea_1=findViewById<TextInputLayout>(R.id.prof_area_1)
        val profArea_2=findViewById<TextInputLayout>(R.id.prof_area_2)
        val articletext=findViewById<TextInputLayout>(R.id.article_text)
        val imageUri=findViewById<TextInputLayout>(R.id.imageUri)


        val btnPostAction=findViewById<Button>(btnPost)


        btnPostAction.setOnClickListener{
            loadDataToDatabase(headerEdit.editText?.text?.trim().toString(),profArea.editText?.text?.trim().toString(),
                articletext.editText?.text?.trim().toString(),"Neuroscience",profArea_1.editText?.text?.trim().toString(),
                profArea_2.editText?.text?.trim().toString(), imageUri.editText?.text?.trim().toString(),45,45, LocalDate.now().toString(),
                "georgeborisov02@gmail.com","George Borisov",13,"https://yandex.ru/search/?text=robert+sapolsky&lr=118936&clid=2261451&win=518&src=suggest_T",
                "https://harsh-winter-cbc.notion.site/df618a434c144737a24e1291a9be9117",
                "https://www.themindvoyager.com/robert-sapolsky-lecture-14-limbic-system/"

            )
            Toast.makeText(applicationContext, "A new item added", Toast.LENGTH_SHORT).show()
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadDataToDatabase(header:String, preview_text:String=R.string.full_text_post.toString(),full_text:String, theme_1:String="Neuroscience", theme_2:String, theme_3:String, uriImage:String,
                           countOfLikes:Int=45, count_of_readers:Int=45,
                           timeOfCreation:String=Date.from(Instant.now()).toString(),
                           email: String="georgeborisov02@gmail.com",
                           author:String="George Borisov",
                           team_id:Int=13,resource_1:String,resource_2:String,resource_3:String
    ){
            itemViewModel.insert(Item(header,preview_text,full_text,theme_1,theme_2,theme_3,uriImage,
                countOfLikes,count_of_readers,timeOfCreation,email,author,team_id,
                resource_1,resource_2,resource_3))

    }

}