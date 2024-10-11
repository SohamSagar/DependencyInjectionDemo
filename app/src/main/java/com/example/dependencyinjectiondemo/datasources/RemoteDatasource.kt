package com.example.dependencyinjectiondemo.datasources

import com.example.dependencyinjectiondemo.api.ApiService
import com.example.dependencyinjectiondemo.model.ProductListModel
import retrofit2.Call
import javax.inject.Inject

class RemoteDatasource @Inject constructor(private val api: ApiService) {

    fun getDataApi(): Call<ProductListModel> {
        return api.getProductData()
    }

}