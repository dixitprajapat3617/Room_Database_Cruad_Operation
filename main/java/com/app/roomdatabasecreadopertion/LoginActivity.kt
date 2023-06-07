package com.app.roomdatabasecreadopertion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.app.roomdatabasecreadopertion.dao.UserDao
import com.app.roomdatabasecreadopertion.database.Appdatabase
import com.app.roomdatabasecreadopertion.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var database:Appdatabase
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database= Room.databaseBuilder(this, Appdatabase::class.java, name = "dixit.db").allowMainThreadQueries().build()


        binding.btnLogin.setOnClickListener {

            var email=binding.etLoginemail.text.toString().trim()
            var password=binding.etLoginPassword.text.toString().trim()
            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(applicationContext, "invalid Input", Toast.LENGTH_SHORT).show()
            }else{
                loginUser(email,password)
            }

        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))


        }
    }

    private fun loginUser(email: String, password: String) {
        var user=database.userdao().checkloginuser(email,password)

        if (user!=null){
            startActivity(Intent(this,HomePageActivity::class.java))
        }else{
            Toast.makeText(applicationContext, "invalid user credential", Toast.LENGTH_SHORT).show()
        }
    }
}