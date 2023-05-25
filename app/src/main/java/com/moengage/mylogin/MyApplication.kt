package com.moengage.mylogin


import android.app.Application
import com.moengage.core.DataCenter
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig
import com.moengage.firebase.MoEFireBaseHelper
import com.moengage.pushbase.MoEPushHelper

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        MoEPushHelper.getInstance().pushPermissionResponse(this, true)
//        MoEFireBaseHelper.getInstance().passPushToken(this,)
        val moEngage = MoEngage.Builder(this, "2877NHMD0TOHATHC6NNHDERW", DataCenter.DATA_CENTER_1)
            .configureNotificationMetaData(NotificationConfig(R.drawable.small_icon, R.drawable.large_icon))
//            .configureFcm(FcmConfig(false))
            .configureLogs(LogConfig(LogLevel.VERBOSE,true))
            .build()
        MoEngage.initialiseDefaultInstance(moEngage)
    }

}