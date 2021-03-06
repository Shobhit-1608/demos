package com.example.demos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.demos.WordRepository;
import com.example.demos.model.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    /**
     * constructor
     * @param application
     */
    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();   // we're getting the data from the repository

    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert(Word word) {
        mRepository.insert(word);
    }
    public void deleteWord(Word word) {
        // mRepository.deleteWord(word);
    }

}