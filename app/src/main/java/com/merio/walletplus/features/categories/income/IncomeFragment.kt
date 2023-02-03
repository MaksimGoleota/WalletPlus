package com.merio.walletplus.features.categories.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.merio.walletplus.R
import com.merio.walletplus.databinding.FragmentIncomeBinding
import com.merio.walletplus.domain.categories.Categories

class IncomeFragment : Fragment() {

    private var _binding: FragmentIncomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = IncomeAdapter()
        recyclerViewIncome.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter.setData(initCategories())
        }
    }

    private fun initCategories(): ArrayList<Categories> {
        val list: ArrayList<Categories> = ArrayList()
        list.add(Categories(getString(R.string.interest_on_deposit), R.drawable.interest_on_deposit))
        list.add(Categories(getString(R.string.business), R.drawable.business))
        list.add(Categories(getString(R.string.present), R.drawable.present))
        list.add(Categories(getString(R.string.salary), R.drawable.salary))
        list.add(Categories(getString(R.string.other), R.drawable.other))
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}