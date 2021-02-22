package com.mukesh.easydatastore

import android.app.Application
import com.mukesh.easydatastoremethods.calldatastore.CallDataStore

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()
        CallDataStore.initializeDataStore(
            context = applicationContext,
            dataBaseName = "DemoAppData"
        )
    }

}