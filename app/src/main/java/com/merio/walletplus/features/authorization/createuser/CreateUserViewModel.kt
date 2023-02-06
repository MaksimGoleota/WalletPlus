package com.merio.walletplus.features.authorization.createuser

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merio.walletplus.domain.database.User
import com.merio.walletplus.domain.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CreateUserViewModel @Inject constructor(
    private val repository: DatabaseRepository
) : ViewModel() {

    private val userLiveData = MutableLiveData<List<User>>()

    fun createUser(user: User) {
            repository.createUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    Log.d("error", it.toString())
                }
                .doFinally {
                    userLiveData.value = listOf(user)
                }
                .subscribe()
    }
}