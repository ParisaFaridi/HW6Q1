package com.example.homework6_question1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.homework6_question1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var name :String
    private lateinit var userName:String
    private lateinit var email :String
    private lateinit var password :String
    private lateinit var gender :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences=getSharedPreferences("preferences", MODE_PRIVATE)
        val editor=sharedPreferences.edit()

        binding.btnRegister.setOnClickListener{

            when {
                binding.etFullName.text.toString().length < 5 -> binding.etFullName.error=
                    "Your name cannot be less than 5 characters"
                binding.etUserName.text.toString().length < 4 -> binding.etUserName.error=
                    "Your username cannot be less than 4 characters"
                binding.etRetypePassword.text.toString()!=binding.etPassword.text.toString() ->
                    binding.etRetypePassword.error=" password and retyped passwords don't match!"
                else -> {
                    name = binding.etFullName.text.toString()
                    userName = binding.etUserName.text.toString()
                    email = binding.etEmail.text.toString()
                    password = binding.etPassword.text.toString()
                    val checkedGenderRadioButton = binding.radioGroup.checkedRadioButtonId
                    gender = findViewById<RadioButton>(checkedGenderRadioButton).text.toString()

                    editor.apply {
                        putString("Full_Name", name)
                        putString("User_Name", userName)
                        putString("Email", email)
                        putString("PassWord", password)
                        putString("Gender", gender)
                        apply()
                    }
                    Toast.makeText(this, "Registration was successful.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.btnShowInfo.setOnClickListener {
            binding.tvFullNameResult.text=sharedPreferences.getString("Full_Name","Unknown")
            binding.tvUserNameResult.text=sharedPreferences.getString("User_Name","No user Name")
            binding.tvEmailResult.text=sharedPreferences.getString("Email","no email")
            binding.tvPasswordResult.text=sharedPreferences.getString("PassWord","no password")
            binding.tvGenderResult.text=sharedPreferences.getString("Gender","Not specified")

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