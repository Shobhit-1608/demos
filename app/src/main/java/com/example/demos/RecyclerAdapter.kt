package com.example.demos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class RecyclerAdapter: Adapter<RecyclerAdapter.ViewHolder>() {


    private var title = arrayOf("chapter one","chapter two","chapter three")
    private var descript = arrayOf("chapter one details","chapter two details","chapter three details")

    private val img = arrayOf(R.drawable.android,R.drawable.android,R.drawable.android)


    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        lateinit var Itemimage: ImageView
        lateinit var itemt1: TextView
        lateinit var itemt2: TextView

        init {
            Itemimage = itemView.findViewById(R.id.relativeimage1)
            itemt1 = itemView.findViewById(R.id.text11)
            itemt2 = itemView.findViewById(R.id.text12)

            itemView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "you clicked on ", Toast.LENGTH_SHORT).show()
            }
        }

    }



    override fun getItemCount(): Int {
        return title.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerlayout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (holder != null) {
            holder.itemt1.text = title[position]
            holder.itemt2.text = descript[position]
            holder.Itemimage.setImageResource(img[position])

        }

    }
}