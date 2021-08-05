package com.example.demos;

import android.os.AsyncTask;

import com.example.demos.model.Word;


public class InsertTask extends AsyncTask<Void,Void,Void> {

    WordDao mWordDao;
    Word mword;

    public InsertTask(WordDao wordDao, Word word){
        mword =word;
        mWordDao = wordDao;
    }



    @Override
    protected Void doInBackground(Void... voids) {
        mWordDao.insert(mword);
        return null;
    }
}