package com.merio.walletplus.features.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.merio.walletplus.R
import com.merio.walletplus.databinding.FragmentCategoriesBinding
import com.merio.walletplus.features.categories.CategoriesHomeTabsAdapter.Companion.tabNames


class CategoriesHomeFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = CategoriesHomeTabsAdapter(requireActivity())
        TabLayoutMediator(tabLayoutCategories, viewPager) { tab, position ->
            tab.text = tabNames[position]
            when (position) {
                0 -> tab.setIcon(R.drawable.income)
                1 -> tab.setIcon(R.drawable.expenses)
            }
            tabLayoutCategories
                .getTabAt(0)
                ?.icon
                ?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                ContextCompat.getColor(requireContext(), R.color.red), BlendModeCompat.SRC_ATOP
            )
        }.attach()

        tabLayoutCategories.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon
                    ?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    ContextCompat.getColor(requireContext(), R.color.red), BlendModeCompat.SRC_ATOP
                )
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon
                    ?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    ContextCompat.getColor(requireContext(), R.color.black),
                    BlendModeCompat.SRC_ATOP
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}