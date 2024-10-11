package com.example.dependencyinjectiondemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dependencyinjectiondemo.databinding.ItemRvBinding
import com.example.dependencyinjectiondemo.model.ProductModelItem

class CustomAdapter(private val data: List<ProductModelItem>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(val b:ItemRvBinding):ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (data.isEmpty())
            return

        holder.b.apply {
            tvName.text = data[position].name
            tvCate.text = data[position].category
        }
    }

}