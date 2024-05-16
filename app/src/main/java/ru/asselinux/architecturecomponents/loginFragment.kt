package ru.asselinux.architecturecomponents

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.data.User
import ru.asselinux.architecturecomponents.room.ItemViewModel
import ru.asselinux.architecturecomponents.room.UserViewModel
import java.util.regex.Pattern


class loginFragment:Fragment(R.layout.login_page) {
    private val userViewModel: UserViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textInputEmail:TextInputLayout=view.findViewById<TextInputLayout>(R.id.text_input_email)
        val textInputPassword:TextInputLayout=view.findViewById(R.id.text_input_password)


        val btnSumbit: Button =view.findViewById<Button>(R.id.btnSubmit)

        btnSumbit.setOnClickListener {
            val email:String =textInputEmail.editText?.text?.trim().toString()
            val password:String=textInputPassword.editText?.text?.trim().toString()
            if (checkTheCredentials(email, password, textInputEmail, textInputPassword)) {
                findNavController().navigate(R.id.mainActivity)
            }

        }

        }


    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^" +  //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +  //any letter //at least 1 special character
                "(?=\\S+$)" +  //no white spaces
                ".{4,}" +  //at least 4 characters
                "$"
    )
    private fun validateEmail(email:String,textInputEmail:TextInputLayout): Boolean {

        return if (email.isEmpty()) {
            textInputEmail.setError("Field can't be empty")
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputEmail.setError("Please enter a valid email address")
            false
        } else {
            textInputEmail.setError(null)
            true
        }
    }

    private fun validatePassword(password:String,textInputPassword:TextInputLayout): Boolean {
        return if (password.isEmpty()) {
            textInputPassword.setError("Field can't be empty")
            false
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            textInputPassword.setError("Password too weak")
            false
        } else {
            textInputPassword.setError(null)
            true
        }
    }

    fun checkTheCredentials(email: String,password: String,textInputEmail: TextInputLayout,textInputPassword: TextInputLayout):Boolean{
        Toast.makeText(view?.context,email,Toast.LENGTH_SHORT).show()
        if (!validateEmail(email, textInputEmail)  or !validatePassword(password, textInputPassword)) {
            return false
        }
        var flag:Boolean=false
        userViewModel.allUsers.observe(
             viewLifecycleOwner,object : Observer<List<User>> {
                override fun onChanged(users: List<User>) {
                    for (user in users){
                        if(user.email.equals(email) and user.password.equals(password)){
                            Toast.makeText(view?.context,"Welcome, ${user.first_name+" "+user.last_name}!",Toast.LENGTH_LONG).show()
                            flag=true
                        }
                    }
                }
            })
        return flag
    }


}
