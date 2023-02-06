package com.merio.walletplus.features.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.merio.walletplus.databinding.FragmentAccountsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountsFragment : Fragment() {

    private var _binding: FragmentAccountsBinding? = null
    private val binding get() = _binding!!

    private val mViewModel: AccountsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getAllUsers()
        val adapter = AccountsAdapter()
        mViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            adapter.setData(user)
        }
        recyclerViewAccounts.adapter = adapter
        recyclerViewAccounts.layoutManager = LinearLayoutManager(context)
        recyclerViewAccounts.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}