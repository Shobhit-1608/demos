package com.example.demos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var layoutManag : RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManag =   LinearLayoutManager(this)
        /*recyclerView.adapter = RecyclerAdapter()
        recyclerView.layoutManager = this.layoutManag*/

    }

}