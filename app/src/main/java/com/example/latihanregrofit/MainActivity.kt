package com.example.latihanregrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.latihanregrofit.Data.ApiServiceImpl
import com.example.latihanregrofit.Data.Model.DatalLiga
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getData()
    }
    private fun getData(){
        ApiServiceImpl.create()
            .getDataLiga("England","Soccer")
            .enqueue(object: Callback<DatalLiga>{
                //ketika gagal respons
                override fun onFailure(call: Call<DatalLiga>, t: Throwable){
                    progressBar.visibility = View.GONE
                    Log.e("Apayangsalah", t.localizedMessage)
                }

                //ketika berhasil
                override fun onResponse(call: Call<DatalLiga>, response: Response<DatalLiga>){
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful){
                        val adapter = LigaRecyclerAdapter(response.body()?.countrys!!)
                        recyclerView.adapter = adapter
                    }
                    }

            })
}}
