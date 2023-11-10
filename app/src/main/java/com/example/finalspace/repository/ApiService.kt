package com.example.finalspace.repository

import com.example.finalspace.data.model.character.Characters
import com.example.finalspace.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("character/")
    suspend fun getAllCharacters(): Characters

}

object RetrofitClient {
    val apiService: ApiService by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(ApiService::class.java)
    }
}