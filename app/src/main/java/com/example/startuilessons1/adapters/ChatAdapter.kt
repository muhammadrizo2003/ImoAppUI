package com.example.startuilessons1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.startuilessons1.R
import com.example.startuilessons1.models.Chat
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(private val context: Context, private val list: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater =
            LayoutInflater.from(context).inflate(R.layout.item_chat_view, parent, false)
        return MessageViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = list[position]

        if (holder is MessageViewHolder) {
            val imageViewProfile = ((holder) as MessageViewHolder).iv_profile
            val textViewFullName = ((holder) as MessageViewHolder).tv_fullName
            val textViewCount = ((holder) as MessageViewHolder).tv_count

            imageViewProfile.setImageResource(chat.profile)
            textViewFullName.text = chat.fullName
            textViewCount.text = chat.count.toString()

            if (chat.count > 0) {
                textViewCount.visibility = View.VISIBLE
            } else {
                textViewCount.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private class MessageViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val iv_profile: ShapeableImageView
        val tv_fullName: TextView
        val tv_count: TextView

        init {
            iv_profile = myItemView.findViewById(R.id.iv_profile)
            tv_fullName = myItemView.findViewById(R.id.tv_fullName)
            tv_count = myItemView.findViewById(R.id.tv_count)
        }
    }
}








