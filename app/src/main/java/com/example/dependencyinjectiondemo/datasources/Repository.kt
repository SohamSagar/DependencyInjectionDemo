package com.example.dependencyinjectiondemo.datasources

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class Repository @Inject constructor(remoteDatasource: RemoteDatasource,localDataSource: LocalDataSource){
    val remote = remoteDatasource
    val local = localDataSource
}