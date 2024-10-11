package com.example.dependencyinjectiondemo.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectiondemo.datasources.Repository
import com.example.dependencyinjectiondemo.model.ProductListModel
import com.example.dependencyinjectiondemo.model.ProductModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository,@ApplicationContext val context: Context):ViewModel() {
    var data:MutableLiveData<List<ProductModelItem>> = MutableLiveData()

    fun getDataApi(){
        repository.remote.getDataApi().enqueue(object :Callback<ProductListModel>{
            override fun onResponse(call: Call<ProductListModel>, response: Response<ProductListModel>) {
                Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show()
                response.body()?.let {
                    if (response.isSuccessful) {
                        data.value = it.data
                        repository.local.setData(it.data)
                    }
                }
            }

            override fun onFailure(call: Call<ProductListModel>, t: Throwable) {
                Toast.makeText(context, "Something Want Wrong!", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }

        })
    }

    fun getDataLocal(){
        data.value = repository.local.getData()
    }
}
