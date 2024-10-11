package com.example.dependencyinjectiondemo.datasources

import com.example.dependencyinjectiondemo.db.ProductDao
import com.example.dependencyinjectiondemo.model.ProductModelItem
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val pd:ProductDao){

    fun setData(data: List<ProductModelItem>){
        pd.setProductData(data)
    }

    fun getData(): List<ProductModelItem> {
        return pd.getProductData()
    }
}