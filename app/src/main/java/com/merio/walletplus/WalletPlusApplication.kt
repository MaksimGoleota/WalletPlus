package com.merio.walletplus

import android.app.Application
import com.merio.walletplus.domain.sharedpreferences.PasswordStorage
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WalletPlusApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        PasswordStorage.init(this)
    }
}