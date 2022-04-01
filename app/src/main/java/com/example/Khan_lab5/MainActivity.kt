package com.example.Khan_lab5

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Khan_lab5.R


class MainActivity : AppCompatActivity() {
    private lateinit var  radioButton: Button
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var stationName: TextView
    private var radioOn: Boolean = false
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stationName = findViewById(R.id.info_text)
        stationName.text = "Taamir Khan Lab 5 - Radio Stations"

        recyclerView = findViewById(R.id.recycleview)
        recyclerView.adapter = RadioAdapter()
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
    }



}