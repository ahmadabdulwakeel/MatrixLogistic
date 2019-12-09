package com.matrixlogistic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matrixlogistic.ui.main.DashboardFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        supportActionBar?.setDisplayShowHomeEnabled(true);
//        supportActionBar?.setLogo(R.drawable.logo);
//        supportActionBar?.setDisplayUseLogoEnabled(true);
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment.newInstance())
                .commitNow()
        }
    }

}
