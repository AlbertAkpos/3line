package me.alberto.a3line.screens.splash.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.alberto.a3line.R
import me.alberto.a3line.screens.home.view.HomeActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timer().schedule(3000) {
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }
    }
}