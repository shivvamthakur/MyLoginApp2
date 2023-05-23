package com.moengage.mylogin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.moengage.cards.ui.CardActivity
import com.moengage.core.MoECoreHelper.logoutUser
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.core.model.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class NewActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val logoutbtn = findViewById<View>(R.id.logoutbtn) as MaterialButton
        val purchasebtn = findViewById<View>(R.id.purchasebtn) as MaterialButton
        val notificationbtn = findViewById<View>(R.id.notificationbtn) as MaterialButton

        val dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
        val now = LocalDateTime.now()


        logoutbtn.setOnClickListener {
            logoutUser(this)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        purchasebtn.setOnClickListener{
            val properties = Properties()
            properties
                // tracking integer
                .addAttribute("quantity", 1)
                // tracking string
                .addAttribute("product", "Sticker_minion")
                // tracking date
                .addAttribute("purchaseDate", dtf.format(now))
                // tracking double
                .addAttribute("price", 255.23)
                // tracking location
                .addAttribute("userLocation", GeoLocation(40.77, 73.98))
            MoEAnalyticsHelper.trackEvent(this, "Purchase", properties)
            notificationbtn.setOnClickListener {
                val intent = Intent(this, CardActivity::class.java)
                startActivity(intent)

        }
    }
}}