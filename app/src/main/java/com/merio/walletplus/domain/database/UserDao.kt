package com.merio.walletplus.domain.database

import androidx.room.*
import androidx.room.Dao
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createUser(user: User): Completable

    @Query("SELECT * FROM user")
    fun getAllUsers(): Single<List<User>>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

}