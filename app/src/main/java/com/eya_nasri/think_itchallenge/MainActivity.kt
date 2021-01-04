package com.eya_nasri.think_itchallenge

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = getSharedPreferences("ThinkITSharedPreferences", Context.MODE_PRIVATE)
        if (wasUserNameSaved()) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
            return
        }
        setContentView(R.layout.activity_main)
        continueBtn.setOnClickListener(this)
        supportActionBar?.hide()
    }
    //Check if the username Field is empty or not
    private fun validate(): Boolean {
        if (usernameField.text.toString().isEmpty()){
            usernameField.error = "Name cannot be empty"
            return false
        }

        return true
    }
    override fun onClick(v: View?){
        when(v?.id){
            R.id.continueBtn->{
                if(validate()){
                    Log.i(null, "setOnClickListener")
                    sharedPref.edit().putString("user_name", usernameField.text.toString()).apply()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    //Check if the user inserted his name
    private fun wasUserNameSaved(): Boolean {
        return sharedPref.getString("user_name", "")?.isNotEmpty()!!
    }


}