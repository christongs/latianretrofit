package com.example.latihanregrofit.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl {

    companion object{
        private val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"

        fun create() : ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }

    }
}