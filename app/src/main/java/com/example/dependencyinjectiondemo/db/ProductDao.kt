package com.example.dependencyinjectiondemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dependencyinjectiondemo.model.ProductModelItem

@Dao
interface ProductDao {
    @Query("select * from product")
    fun getProductData(): List<ProductModelItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setProductData(list: List<ProductModelItem>)
}