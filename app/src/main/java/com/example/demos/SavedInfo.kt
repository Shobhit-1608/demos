package com.example.demos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import com.example.demos.model.Word
import android.widget.ListView
import android.widget.TextView


class SavedInfo : AppCompatActivity() {


    lateinit var  roomDb: WordRoomDb
    lateinit var wordDao: WordDao
    lateinit var etOne: EditText
    lateinit var listview: ListView

    lateinit var adapter: ArrayAdapter<String>
    lateinit var wordTextView: TextView
    lateinit var mWordViewModel: WordViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_info)
        etOne = findViewById(R.id.etOne)

        roomDb = WordRoomDb.getDatabase(this)
        wordDao = roomDb.wordDao()
        listview = findViewById(R.id.dblist)


    }
    override fun onStart() {
        super.onStart()
        getDataAsync()
    }
    private fun getDataAsync() {
        var task =    getDataTask(this,listview,wordDao)
        task.execute()
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun saveData() {
        //get the data from edittext
        var data = etOne.text.toString()
        // create a file
        var sharedPreferences = getSharedPreferences("mtapfile", MODE_PRIVATE)
        //open the file
        var editor = sharedPreferences.edit()
        //write to the file
        editor.putString("name",data)
        // editor.putBoolean() --save the state of a check box
        //save the file
        editor.apply()

    }

    override fun onResume() {
        super.onResume()
        restoreData()
    }

    private fun restoreData() {
        //open file
        var sharedPreferences = getSharedPreferences("mtapfile", MODE_PRIVATE)
        //get data from file
        var data  = sharedPreferences.getString("name","")
        //set the data into edittext
        etOne.setText(data)

    }

    fun dbHandler(view: View) {
        insertWordAsynchronously()
    }

    private fun insertWordAsynchronously() {
        var data = etOne.text.toString()
        var word = Word(data)
        var insertTask = InsertTask(wordDao,word)
        insertTask.execute()
    }

    fun dbDeleter(view: View) {
        deleteWordAsynchronously()
    }

    private fun deleteWordAsynchronously() {
       // wordDao.deleteLatestWord();
        var delTask = DeleteTask(wordDao,Word("myword"))
        delTask.execute()

    }
}