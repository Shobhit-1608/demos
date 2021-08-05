package com.example.demos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//contains the data base holder methods and serves the main connection

@Database(entities = [User:: class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao
    companion object{  //this companion object will be visble to other classes
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null)
            {
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}