package com.example.homework6_question1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.homework6_question1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var name :String
    lateinit var userName:String
    lateinit var email :String
    lateinit var password :String
    lateinit var gender :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences=getSharedPreferences("preferences", MODE_PRIVATE)
        val editor=sharedPreferences.edit()

        binding.btnRegister.setOnClickListener{
            name =binding.etFullName.text.toString()
            userName =binding.etUserName.text.toString()
            email =binding.etEmail.text.toString()
            password =binding.etFullName.text.toString()
            val checkedGenderRadioButton=binding.radioGroup.checkedRadioButtonId
            gender =findViewById<RadioButton>(checkedGenderRadioButton).text.toString()

            editor.apply {
                putString("Full Name",name)
                putString("User Name",userName)
                putString("Email",email)
                putString("PassWord",password)
                putString("Gender",gender)
                apply()
            }
        }

//        binding.btnShowInfo.setOnClickListener {
//            binding.tvShowInfo.text="Full name: ${sharedPreferences.getString(name,name)}\n" +
//                    "User name:${sharedPreferences.getString(userName, userName)}\n" +
//                    "Email:${sharedPreferences.getString(email, email)}\n" +
//                    "Password: ${sharedPreferences.getString(password, password)}\n" +
//                    "Full name: ${sharedPreferences.getString(gender, gender)}\n"
//
//        }

    }
}