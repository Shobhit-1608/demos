package com.example.demos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//contains methods useful for accessing the database
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser (user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData (): LiveData<List<User>>

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

}