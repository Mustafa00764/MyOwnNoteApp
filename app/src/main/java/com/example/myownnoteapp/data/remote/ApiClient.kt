package com.example.myownnoteapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    private  const val BASE_URL = "https://650060bf18c34dee0cd4d05c.mockapi.io/"

  private val retrofit = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()



    val apiService = retrofit.create(ApiService::class.java)
}