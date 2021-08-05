package com.example.demos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// this class represents an entity on the data base.


@Entity(tableName = "user_table")
class User (
    @PrimaryKey(autoGenerate = true)//Room library will autogenerate for our data
    val Id: Int,
    val firstName: String
        )