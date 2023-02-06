package com.merio.walletplus.features.categories.expenses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.merio.walletplus.R
import com.merio.walletplus.databinding.RecyclerviewCategoriesItemBinding
import com.merio.walletplus.domain.categories.Categories
import com.squareup.picasso.Picasso

class ExpensesAdapter : RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder>() {

    class ExpensesViewHolder(val binding: RecyclerviewCategoriesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val categoriesList: MutableList<Categories> = mutableListOf()

    fun setData(category: List<Categories>) {
        categoriesList.clear()
        categoriesList.addAll(category)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val binding = RecyclerviewCategoriesItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpensesViewHolder(binding)
    }

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        with(holder.binding) {
            val currentItem = categoriesList[position]
            nameCategory.text = currentItem.name

            Picasso.get()
                .load(currentItem.drawable)
                .into(iconForCategory)
        }
    }
}