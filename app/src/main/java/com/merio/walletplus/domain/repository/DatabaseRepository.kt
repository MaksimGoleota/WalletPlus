package com.merio.walletplus.domain.repository


import com.merio.walletplus.domain.database.Database
import com.merio.walletplus.domain.database.User
import io.reactivex.Single
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val database: Database
) {

    fun getAllUsers(): Single<List<User>> = database.userDao().getAllUsers()
    fun createUser(user: User) = database.userDao().createUser(user)
    fun updateUser(user: User) = database.userDao().updateUser(user)
    fun deleteUser(user: User) = database.userDao().deleteUser(user)
}