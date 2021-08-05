package com.example.demos;

import android.os.AsyncTask;
import android.util.Log;

import com.example.demos.model.Word;

public class DeleteTask extends AsyncTask<Void,Void,Void> {
public static String TAG = DeleteTask.class.getSimpleName();

    WordDao mWordDao;
    Word mword;

    public DeleteTask(WordDao wordDao, Word word){
        mword =word;
        mWordDao = wordDao;
    }


    @Override
    protected Void doInBackground(Void... voids) {
       int no = mWordDao.deleteAllWords();
        Log.i(TAG,"no of rows deleted = "+no);

        return null;
    }
}
