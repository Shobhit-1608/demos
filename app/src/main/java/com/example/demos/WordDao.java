package com.example.demos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.demos.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    //insert into Word {uid,tile} values {1,"abdul"}
    @Insert
    void insert(Word word);

    @Query("Delete from Word")
    int deleteAllWords();

    @Query("SELECT * from Word ORDER BY title ASC")

    LiveData<List<Word>> getAllWords();
}

