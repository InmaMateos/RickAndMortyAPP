package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.data.RepositoryImpl
import com.example.rickandmortyapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun provideRickAndMortyApiService(retrofit: Retrofit): RickAndMortyApiService {
    return retrofit.create(RickAndMortyApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: RickAndMortyApiService): Repository {
        return RepositoryImpl(apiService)
    }
}