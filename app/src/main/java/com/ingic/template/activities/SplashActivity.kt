package com.ingic.template.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import com.ingic.template.R

import java.util.Timer


class SplashActivity : AppCompatActivity() {

    internal val MIN_TIME_INTERVAL_FOR_SPLASH = 2500 // in millis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    public override fun onResume() {
        super.onResume()
        launchTimerAndTask()
    }

    private fun launchTimerAndTask() {
        Handler().postDelayed({ showMainActivity() }, MIN_TIME_INTERVAL_FOR_SPLASH.toLong())
    }

    private fun showMainActivity() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
}