package com.matrixlogistic.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matrixlogistic.R
import kotlinx.android.synthetic.main.about_us.*
import kotlinx.android.synthetic.main.dashboard.*
import android.content.Intent
import android.net.Uri
import android.util.Patterns
import android.webkit.URLUtil


class AboutFragment : Fragment() {
    companion object {
        fun newInstance() = AboutFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.about_us, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        air_freight.setOnClickListener {
            "http://www.matrixlogistic.com/Home/AirFreight".openURL()
        }
        sea_freight.setOnClickListener {
            "http://www.matrixlogistic.com/Home/SeaFreight".openURL()
        }
        road.setOnClickListener {
            "http://www.matrixlogistic.com/Home/RoadTransportation".openURL()
        }
        warehousing.setOnClickListener {
            "http://www.matrixlogistic.com/Home/WarehousingAndDistribution".openURL()
        }
        project.setOnClickListener {
            "http://www.matrixlogistic.com/Home/ProjectHandling".openURL()
        }
        custom.setOnClickListener {
            "http://www.matrixlogistic.com/Home/CustomClearance".openURL()
        }

    }

    fun String.openURL() {
        try {
            if (Patterns.WEB_URL.matcher(this).matches()) {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(this)
                startActivity(i)
            }
        } catch (e: Exception) {
        }
    }

}
