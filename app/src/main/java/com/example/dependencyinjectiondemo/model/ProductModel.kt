package com.example.dependencyinjectiondemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ProductListModel(val data:ArrayList<ProductModelItem>)

@Entity(tableName = "Product")
data class ProductModelItem(
	@PrimaryKey(autoGenerate = false)
	val id: Int = 0,
	val name: String = "",
	val price: Double = 0.0,
	val category: String? = null,
	val inStock: Boolean? = null
)

