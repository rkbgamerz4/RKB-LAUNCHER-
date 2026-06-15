package com.movtery.zalithlauncher

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.movtery.zalithlauncher.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        )

        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.splash_logo)
        val title = findViewById<TextView>(R.id.splash_title)
        val subtitle = findViewById<TextView>(R.id.splash_subtitle)
        val tagline = findViewById<TextView>(R.id.splash_tagline)
        val progress = findViewById<ProgressBar>(R.id.splash_progress)
        val version = findViewById<TextView>(R.id.splash_version)

        logo.animate().alpha(1f).scaleX(1.1f).scaleY(1.1f).setDuration(600).setStartDelay(200)
            .withEndAction {
                logo.animate().scaleX(1f).scaleY(1f).setDuration(300).start()
            }.start()

        title.animate().alpha(1f).translationYBy(-10f).setDuration(500).setStartDelay(500).start()
        subtitle.animate().alpha(1f).setDuration(500).setStartDelay(700).start()
        tagline.animate().alpha(1f).setDuration(500).setStartDelay(900).start()
        progress.animate().alpha(1f).setDuration(400).setStartDelay(1000).start()
        version.animate().alpha(1f).setDuration(400).setStartDelay(1100).start()

        logo.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 3000)
    }
}
