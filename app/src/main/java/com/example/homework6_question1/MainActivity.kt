package com.example.homework6_question1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
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

            if (binding.etFullName.text.toString().length < 5)
                binding.etFullName.error="Your name cannot be less than 5 characters"

            else if (binding.etUserName.text.toString().length < 4)
                binding.etUserName.error="Your username cannot be less than 4 characters"


            if (binding.etRetypePassword.text.toString()!=binding.etPassword.text.toString())
                binding.etRetypePassword.error=" password and retyped passwords don't match!"
            else {
                name = binding.etFullName.text.toString()
                userName = binding.etUserName.text.toString()
                email = binding.etEmail.text.toString()
                password = binding.etPassword.text.toString()
                val checkedGenderRadioButton = binding.radioGroup.checkedRadioButtonId
                gender = findViewById<RadioButton>(checkedGenderRadioButton).text.toString()

                editor.apply {
                    putString("Full Name", name)
                    putString("User Name", userName)
                    putString("Email", email)
                    putString("PassWord", password)
                    putString("Gender", gender)
                    apply()
                }
                Toast.makeText(this, "Registration was successful.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnShowInfo.setOnClickListener {

            binding.tvFullNameResult.text=sharedPreferences.getString(name,name)
            binding.tvUserNameResult.text=sharedPreferences.getString(userName,userName)
            binding.tvEmailResult.text=sharedPreferences.getString(email,email)
            binding.tvPasswordResult.text=sharedPreferences.getString(password,password)
            binding.tvGenderResult.text=sharedPreferences.getString(gender,gender)

            binding.tvFullNameResult.visibility = View.VISIBLE
            binding.tvUserNameResult.visibility = View.VISIBLE
            binding.tvEmailResult.visibility = View.VISIBLE
            binding.tvPasswordResult.visibility = View.VISIBLE
            binding.tvGenderResult.visibility = View.VISIBLE
            binding.btnHideInfo.visibility=View.VISIBLE
        }

        binding.btnHideInfo.setOnClickListener {
            binding.tvFullNameResult.visibility = View.GONE
            binding.tvUserNameResult.visibility = View.GONE
            binding.tvEmailResult.visibility = View.GONE
            binding.tvPasswordResult.visibility = View.GONE
            binding.tvGenderResult.visibility = View.GONE
            binding.btnHideInfo.visibility=View.GONE

        }
    }
}