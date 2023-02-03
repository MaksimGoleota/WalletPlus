package com.merio.walletplus.features.categories.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.merio.walletplus.R
import com.merio.walletplus.databinding.FragmentExpensesBinding
import com.merio.walletplus.domain.categories.Categories
import com.merio.walletplus.features.categories.income.IncomeAdapter


class ExpensesFragment : Fragment() {

    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = IncomeAdapter()
        recyclerViewExpenses.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter.setData(initCategories())
        }
    }

    private fun initCategories(): ArrayList<Categories> {
        val list: ArrayList<Categories> = ArrayList()
        list.add(Categories(getString(R.string.car), R.drawable.car))
        list.add(Categories(getString(R.string.appliances), R.drawable.appliances))
        list.add(Categories(getString(R.string.children), R.drawable.children))
        list.add(Categories(getString(R.string.pets), R.drawable.pets))
        list.add(Categories(getString(R.string.health_and_beauty), R.drawable.health_and_beauty))
        list.add(Categories(getString(R.string.mortgages_debts_loans), R.drawable.mortgages_debts_loans))
        list.add(Categories(getString(R.string.apartment_and_utilities), R.drawable.apartment_and_utilities))
        list.add(Categories(getString(R.string.taxes_and_insurance), R.drawable.taxes_and_insurance))
        list.add(Categories(getString(R.string.education), R.drawable.education))
        list.add(Categories(getString(R.string.clothes_and_accessories), R.drawable.clothes_and_accessories))
        list.add(Categories(getString(R.string.recreation_and_entertainment), R.drawable.recreation_and_entertainment))
        list.add(Categories(getString(R.string.nutrition), R.drawable.nutrition))
        list.add(Categories(getString(R.string.repair), R.drawable.repair))
        list.add(Categories(getString(R.string.household_products), R.drawable.household_products))
        list.add(Categories(getString(R.string.transport), R.drawable.transport))
        list.add(Categories(getString(R.string.hobby), R.drawable.hobby))
        list.add(Categories(getString(R.string.interior), R.drawable.interior))
        list.add(Categories(getString(R.string.present), R.drawable.present))
        list.add(Categories(getString(R.string.other), R.drawable.other))
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}