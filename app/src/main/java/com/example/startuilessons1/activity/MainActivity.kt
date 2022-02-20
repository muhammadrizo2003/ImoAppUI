package com.example.startuilessons1.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startuilessons1.R
import com.example.startuilessons1.adapters.ChatAdapter
import com.example.startuilessons1.models.Chat

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 1)

        refreshAdapter(recyclerView, getAllChats())
    }

    private fun refreshAdapter(recyclerView: RecyclerView, chats: ArrayList<Chat>) {
        val chatAdapter = ChatAdapter(context, chats)
        recyclerView.adapter = chatAdapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        val chats = ArrayList<Chat>()

        for (i in 1..10) {
            chats.add(Chat(R.drawable.img, "Xurshidbek Kurbanov", 1))
            chats.add(Chat(R.drawable.img, "Begzodbek Kurbanov", 0))
            chats.add(Chat(R.drawable.img, "Sherzodbek Kurbanov", 5))
            chats.add(Chat(R.drawable.img, "Xurshidbek Kurbanov", 12))
            chats.add(Chat(R.drawable.img, "Sherzodbek Kurbanov", 0))
        }
        return chats
    }
}



