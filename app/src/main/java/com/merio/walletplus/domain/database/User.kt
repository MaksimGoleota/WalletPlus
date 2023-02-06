package com.merio.walletplus.domain.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User(
    @PrimaryKey(autoGenerate = false)
    var user_id: Long = 0,
    var name: String?,
    var email: String?,
    var balance: String,
)