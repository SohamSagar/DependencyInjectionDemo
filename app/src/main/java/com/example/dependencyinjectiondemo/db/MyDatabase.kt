package com.example.dependencyinjectiondemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dependencyinjectiondemo.model.ProductModelItem

@Database(entities = [ProductModelItem::class], exportSchema = false, version = 1)
abstract class MyDatabase:RoomDatabase(){
    abstract fun productDao():ProductDao
}