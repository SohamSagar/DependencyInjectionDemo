package com.example.dependencyinjectiondemo.api

import com.example.dependencyinjectiondemo.model.ProductListModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("aaf4ef24-57b4-4a26-a524-cff4d38bfcf7")
    fun getProductData():Call<ProductListModel>
}