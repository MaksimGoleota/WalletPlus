package com.merio.walletplus.features.categories.income

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.merio.walletplus.R
import com.merio.walletplus.domain.categories.Categories
import com.squareup.picasso.Picasso

class IncomeAdapter : RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>() {

    private val categories: MutableList<Categories> = mutableListOf()

    fun setData(category: List<Categories>) {
        categories.clear()
        categories.addAll(category)
        notifyDataSetChanged()
    }

    class IncomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameCategory: TextView = itemView.findViewById(R.id.nameCategory)
        val iconForCategory: ImageView = itemView.findViewById(R.id.iconForCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_categories_item, parent, false)
        return IncomeViewHolder(itemView)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) {
        with(holder) {
            val currentItem = categories[position]
            nameCategory.text = currentItem.name

            Picasso.get()
                .load(currentItem.drawable)
                .into(iconForCategory)
        }
    }
}