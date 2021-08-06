package com.example.demos.assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import com.example.demos.R
import kotlinx.android.synthetic.main.activity_third_task.*

class ThirdTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_task)

        button2?.setOnClickListener {
            showPopup(button2)
        }
    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.header_menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.header1 -> {
                    Toast.makeText(this@ThirdTask, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.header2 -> {
                    Toast.makeText(this@ThirdTask, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.header3 -> {
                    Toast.makeText(this@ThirdTask, item.title, Toast.LENGTH_SHORT).show()
                }
            }

            true
        })

        popup.show()
    }
}