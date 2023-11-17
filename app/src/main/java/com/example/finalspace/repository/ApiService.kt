package com.example.finalspace.repository

import com.example.finalspace.data.model.character.Character
import com.example.finalspace.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getAllCharacters():List<Character>

    @GET("character/")
    suspend fun searchCharacters(@Query("search") query: String): List<Character>
}

object RetrofitClient {
    val apiService: ApiService by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(ApiService::class.java)
    }
}