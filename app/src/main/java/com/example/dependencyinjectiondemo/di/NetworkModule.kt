package com.example.dependencyinjectiondemo.di

import android.content.Context
import androidx.room.Room
import com.example.dependencyinjectiondemo.api.ApiService
import com.example.dependencyinjectiondemo.db.MyDatabase
import com.example.dependencyinjectiondemo.db.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun retrofitInstance(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun setupDatabase(@ApplicationContext context: Context): MyDatabase {
        // Return the actual database instance by calling build() on the RoomDatabase.Builder
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "DependencyInjectionDemo"
        ).allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun productDao(db: MyDatabase): ProductDao {
        return db.productDao()
    }
}
