package com.example.demos.assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.demos.R

class FirstTask : AppCompatActivity() {
    lateinit var edittext : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
        init()
    }

    fun init(){
        edittext = findViewById(R.id.passwd)
    }

    fun FisrtOnClick(view: View){
        when(view.id){
            R.id.passwdBtn->{
                edittext.setSelectAllOnFocus(true)
                edittext.selectAll()
            }
        }
    }
}