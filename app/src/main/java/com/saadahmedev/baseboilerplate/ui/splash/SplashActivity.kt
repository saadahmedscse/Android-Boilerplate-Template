package com.saadahmedev.baseboilerplate.ui.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.saadahmedev.baseboilerplate.R
import com.saadahmedev.baseboilerplate.helper.delay
import com.saadahmedev.baseboilerplate.helper.getBearerToken
import com.saadahmedev.baseboilerplate.ui.auth.AuthActivity
import com.saadahmedev.baseboilerplate.ui.dashboard.DashboardActivity
import com.saadahmedsoft.shortintent.Anim
import com.saadahmedsoft.shortintent.ShortIntent

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setContentView(R.layout.activity_splash)

        delay(1500) {
            ShortIntent.getInstance(this)
                .addDestination(if (getBearerToken() == null) AuthActivity::class.java else DashboardActivity::class.java)
                .addTransition(Anim.FADE)
                .finish(this)
        }
    }
}