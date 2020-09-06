package com.example.lab8

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main2.view.*

class MyAdapter (private val contact:ArrayList<Contact>) : RecyclerView.
Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tv_name = v.findViewById<TextView>(R.id.tv_name)
        val tv_phone = v.findViewById<TextView>(R.id.tv_phone)
        val img_delete = v.FindViewById<ImageView>(R.id.img_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val v = LayoutInflater.from(viewGroup:context)
            .inflate(R.layout.adapter_row, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = contacts[position].name
        holder.tv_phone.text = contacts[position].phone
        holder.img_delete.setOnClickListener{
            contact.removeAt(position)
            notifyDataSetChanged()
        }
    }
}


