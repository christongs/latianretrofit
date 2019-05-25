package com.example.latihanregrofit.Data

import com.example.latihanregrofit.Data.Model.DatalLiga
import retrofit2.http.GET
import retrofit2.http.Query
import  retrofit2.Call

interface ApiService {

    @GET("search_all_leagues.php")
    fun getDataLiga (@Query("c") liga: String,
                     @Query("s") sport: String)
            :Call<DatalLiga>
}