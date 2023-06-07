package com.app.roomdatabasecreadopertion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.roomdatabasecreadopertion.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var getname=intent.getStringExtra("NAME")
        var getemail=intent.getStringExtra("EMAIL")
        var getgender=intent.getStringExtra("GENDER")
        var dob=intent.getStringExtra("DOB")

        binding.tvName.setText("name : $getname")
        binding.tvEmail.setText("name : $getemail")
        binding.tvGender.setText("name : $getgender")
        binding.tvDate.setText("name : $dob")
    }
}