package com.matrixlogistic.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matrixlogistic.R
import android.os.Handler
import android.content.Intent
import com.matrixlogistic.MainActivity






class SplashActivity : AppCompatActivity() {
    private val mWaitHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        val mWaitHandler = Handler()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mWaitHandler.postDelayed({
            try {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)

                finish()
            } catch (ignored: Exception) {
                ignored.printStackTrace()
            }
        }, 3000)
    }

    public override fun onDestroy() {
        super.onDestroy()

        mWaitHandler.removeCallbacksAndMessages(null)
    }
}
