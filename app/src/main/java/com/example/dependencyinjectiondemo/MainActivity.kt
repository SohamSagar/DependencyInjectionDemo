package com.example.dependencyinjectiondemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectiondemo.adapter.CustomAdapter
import com.example.dependencyinjectiondemo.databinding.ActivityMainBinding
import com.example.dependencyinjectiondemo.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.data.observe(this@MainActivity){
            if (!it.isNullOrEmpty()){
                Toast.makeText(this, "Test ${i++}", Toast.LENGTH_SHORT).show()
                binding.rvProduct.adapter = CustomAdapter(it)
            }
        }

        if (AppUtils.isInternetAvailable(this))
            viewModel.getDataApi()
        else
            viewModel.getDataLocal()

    }
}