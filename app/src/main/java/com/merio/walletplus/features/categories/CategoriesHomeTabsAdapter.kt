package com.merio.walletplus.features.categories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.merio.walletplus.features.categories.expenses.ExpensesFragment
import com.merio.walletplus.features.categories.income.IncomeFragment

class CategoriesHomeTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    companion object {
        val tabNames = arrayOf("Income", "Expenses")
    }

    override fun getItemCount(): Int {
        return tabNames.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                IncomeFragment()
            }
            else -> {
                ExpensesFragment()
            }
        }
    }
}