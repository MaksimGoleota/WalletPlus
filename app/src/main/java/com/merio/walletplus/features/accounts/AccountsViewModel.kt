package com.merio.walletplus.features.accounts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merio.walletplus.R
import com.merio.walletplus.domain.database.User
import com.merio.walletplus.domain.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AccountsViewModel @Inject constructor(
    private val repository: DatabaseRepository
) : ViewModel() {

    val userLiveData = MutableLiveData<List<User>>()

    fun getAllUsers() {
            repository.getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    Log.d(R.string.error.toString(), it.toString())
                }
                .doOnSuccess {
                    userLiveData.value = it
                }
                .subscribe()
    }
}