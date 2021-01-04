package com.eya_nasri.think_itchallenge

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.util.*
import kotlinx.android.synthetic.main.activity_home.*



class HomeActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPref = getSharedPreferences("ThinkITSharedPreferences", Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val calendar: Calendar = Calendar.getInstance()
        val currentDate: String =
            DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.time)
        DateTxt.text = currentDate

        val username: String = sharedPref.getString("user_name", "username").toString()
        val Welcome: String = "Welcome, $username!"
        WelcomingTxt.text = Welcome

        supportActionBar?.hide()

        layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager
        adapter = RecyclerViewAdapter()
        recycleView.adapter = adapter




    }
}