package com.example.homework6_question1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.homework6_question1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences=getSharedPreferences("preferences", MODE_PRIVATE)
        val editor=sharedPreferences.edit()

        binding.btnRegister.setOnClickListener{
            var name =binding.etFullName.text.toString()
            var userName =binding.etUserName.text.toString()
            var email =binding.etEmail.text.toString()
            var password =binding.etFullName.text.toString()
            if (password != binding.etRetypePassword.text.toString())
                binding.etRetypePassword.error="password and retyped password do not match!"
            val checkedGenderRadioButton=binding.radioGroup.checkedRadioButtonId
            var gender =findViewById<RadioButton>(checkedGenderRadioButton).text.toString()

            editor.apply {
                putString("Full Name",name)
                putString("User Name",userName)
                putString("Email",email)
                putString("PassWord",password)
                putString("Gender",gender)
                apply()
            }
        }

    }
}