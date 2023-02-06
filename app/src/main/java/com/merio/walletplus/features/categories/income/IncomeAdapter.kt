package com.merio.walletplus.features.categories.income

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merio.walletplus.databinding.RecyclerviewCategoriesItemBinding
import com.merio.walletplus.domain.categories.Categories
import com.squareup.picasso.Picasso

class IncomeAdapter : RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>() {

    class IncomeViewHolder(val binding: RecyclerviewCategoriesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val categoriesList: MutableList<Categories> = mutableListOf()

    fun setData(category: List<Categories>) {
        categoriesList.clear()
        categoriesList.addAll(category)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        val binding = RecyclerviewCategoriesItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return IncomeViewHolder(binding)
    }

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) {
        with(holder.binding) {
            val currentItem = categoriesList[position]
            nameCategory.text = currentItem.name

            Picasso.get()
                .load(currentItem.drawable)
                .into(iconForCategory)
        }
    }
}