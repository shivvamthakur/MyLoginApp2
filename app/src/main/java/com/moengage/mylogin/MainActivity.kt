package com.moengage.mylogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper.setUniqueId
import com.moengage.core.analytics.MoEAnalyticsHelper.trackEvent
import com.moengage.pushbase.MoEPushHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val properties = Properties()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<View>(R.id.username) as TextView
        val password = findViewById<View>(R.id.password) as TextView
        val loginbtn = findViewById<View>(R.id.loginbtn) as MaterialButton
        val signupbtn = findViewById<View>(R.id.signupbtn) as MaterialButton

        MoEPushHelper.getInstance().requestPushPermission(this)


        //admin and admin
        loginbtn.setOnClickListener {
            if (password.text.toString() == "admin") {
                //correct
                Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                setUniqueId(this, username.text.toString())
                val intent = Intent(applicationContext, NewActivity::class.java)
                startActivity(intent)
            } else  //incorrect
                Toast.makeText(
                    this,
                    "LOGIN FAILED !!! Wrong password",
                    Toast.LENGTH_SHORT
                ).show()
        }
        signupbtn.setOnClickListener {
            properties // tracking integer
                .addAttribute("visited", " ")
            // tracking string
//                        .addAttribute("product", "iPhone");
            // tracking Date
//                        .addAttribute("purchaseDate", new Date())
//                        // tracking double
//                        .addAttribute("price", 5999.99)
//                        // tracking location
//                        .addAttribute("userLocation", new Geolocation(40.77, 73.98));
            trackEvent(this, "SignUpClicked", properties)
            val intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
        }
    }
}