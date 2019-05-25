package com.example.latihanregrofit

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.latihanregrofit.Data.Model.Country
import kotlinx.android.synthetic.main.item_liga.view.*

class LigaRecyclerAdapter(private val list: List<Country>) : RecyclerView
    .Adapter<LigaRecyclerAdapter.ViewHolder>(){

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        fun onBind(data: Country){
            itemView.textviewLiga.text = data.strLeague
            Glide.with(itemView.context).load(data.strBadge)
                .into(itemView.imageviewLiga)

            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailLigaActivity::class.java)
                intent.putExtra("data", data)
                itemView.context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LigaRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_liga, p0, false)
        return ViewHolder(view)
     }

    override fun getItemCount():Int = list.size

    override fun onBindViewHolder(p0: LigaRecyclerAdapter.ViewHolder, p1: Int)
        = p0.onBind(list[p1])
}