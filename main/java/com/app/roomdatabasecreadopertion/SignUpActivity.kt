package com.app.roomdatabasecreadopertion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.roomdatabasecreadopertion.database.Appdatabase
import com.app.roomdatabasecreadopertion.databinding.ActivitySignUpBinding
import com.app.roomdatabasecreadopertion.model.UserData

class SignUpActivity : AppCompatActivity() {
    lateinit var database:Appdatabase
    var gender=""
    var dob=""
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database=Room.databaseBuilder(this,Appdatabase::class.java, name = "dixit.db").allowMainThreadQueries().build()

        binding.btnSignup.setOnClickListener {
            var name=binding.etName.text.toString().trim()
            var email=binding.etEmail.text.toString().trim()
            var password=binding.etPassword.text.toString().trim()
            var comfrompassword=binding.etComformPassword.text.toString().trim()
            var dob = binding.etDate.text.toString().trim()

            if (name.isEmpty()||email.isEmpty()||password.isEmpty()||comfrompassword.isEmpty()||dob.isEmpty()){
                Toast.makeText(this, "enter user input", Toast.LENGTH_SHORT).show()
            }else{
                var intent=Intent(this,LoginActivity::class.java)

                intent.putExtra("NAME",name)

                intent.putExtra("EMAIL",email)
                intent.putExtra("PASSWORD",password)

                intent.putExtra("GENDER",gender)
                intent.putExtra("DOB",dob)
                startActivity(intent)
            }

            createUserAccount(name,email,password,comfrompassword,dob,gender)



        }
    }

    private fun createUserAccount(name: String, email: String, password: String, comfrompassword: String, dob: String, gender: String) {

            var user=UserData(name = name, email = email, password = password, comfrompassword = comfrompassword, dob = dob, gender = gender)
            try {

                database.userdao().inseruser(user)
                Toast.makeText(applicationContext, "saved", Toast.LENGTH_SHORT).show()
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }


    }


    fun radiobuttonclicked(view:View){
            when(view.id){

                R.id.male_radio->gender="Male"
                R.id.female_radio->gender="Female"
            }
    }


}