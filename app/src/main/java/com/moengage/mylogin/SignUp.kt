package com.moengage.mylogin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.moengage.core.analytics.MoEAnalyticsHelper.setEmailId
import com.moengage.core.analytics.MoEAnalyticsHelper.setFirstName
import com.moengage.core.analytics.MoEAnalyticsHelper.setGender
import com.moengage.core.analytics.MoEAnalyticsHelper.setLastName
import com.moengage.core.analytics.MoEAnalyticsHelper.setUniqueId
import com.moengage.core.analytics.MoEAnalyticsHelper.setUserAttribute
import com.moengage.inapp.MoEInAppHelper


class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val firstName = findViewById<View>(R.id.firstName) as TextView
        val lastName = findViewById<View>(R.id.lastName) as TextView
        val email = findViewById<View>(R.id.email) as TextView
//        val gender = findViewById<View>(R.id.gender) as TextView
        val setPassword = findViewById<View>(R.id.setPass) as TextView
        val registerbtn = findViewById<View>(R.id.registerbtn) as MaterialButton
        registerbtn.setOnClickListener {
            setUniqueId(this, email.text.toString())
            setFirstName(this, firstName.text.toString())
            setLastName(this, lastName.text.toString())
            setEmailId(this, email.text.toString())
//           setGender(this, gender)
            setUserAttribute(this, "SetPassword", setPassword.text.toString())

//                CUSTOM ATTRIBUTES NOT WORKING
            //                if(password.getText().toString().equals("admin")){
//                    //correct
//                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
//                    MoEAnalyticsHelper.INSTANCE.setUniqueId(MainActivity.this,username.getText().toString());
//                    Intent intent = new Intent(getApplicationContext(),NewActivity.class);
//                    startActivity(intent);
//                }else
//                    //incorrect
//                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!! Wrong password",Toast.LENGTH_SHORT).show();

        }


    }

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }

}