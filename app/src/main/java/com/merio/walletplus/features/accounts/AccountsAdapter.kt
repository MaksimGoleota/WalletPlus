package com.merio.walletplus.features.accounts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.merio.walletplus.databinding.RecyclerviewAccountsItemBinding
import com.merio.walletplus.databinding.RecyclerviewCategoriesItemBinding
import com.merio.walletplus.domain.database.User

class AccountsAdapter : RecyclerView.Adapter<AccountsAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: RecyclerviewAccountsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val usersList: MutableList<User> = mutableListOf()

    fun setData(user: List<User>) {
        usersList.clear()
        usersList.addAll(user)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = RecyclerviewAccountsItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder.binding) {
            val currentItem = usersList[position]
            userName.text = currentItem.name
            userEmail.text = currentItem.email
            amountMoney.text = currentItem.balance
        }
    }
}