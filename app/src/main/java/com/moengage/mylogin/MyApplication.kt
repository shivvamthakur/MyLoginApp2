package com.moengage.mylogin


import android.app.Application
import com.moengage.core.DataCenter
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val moEngage = MoEngage.Builder(this, "5ZCYAM3ICF13B6YGB13EPTTM", DataCenter.DATA_CENTER_1)
            .configureFcm(FcmConfig(false))
            .configureLogs(LogConfig(LogLevel.VERBOSE,true))
            .build()
        MoEngage.initialiseDefaultInstance(moEngage)
    }
}