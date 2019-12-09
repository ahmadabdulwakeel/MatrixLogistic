package com.matrixlogistic.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matrixlogistic.R
import kotlinx.android.synthetic.main.dashboard.*

class DashboardFragment : Fragment() {
    companion object {
        fun newInstance() = DashboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        imageView.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                    .add(R.id.container, TrackingFragment.newInstance()).addToBackStack(TrackingFragment.javaClass.simpleName)
                    .commit()
            }
        }

        imageView2.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                    .add(R.id.container, AboutFragment.newInstance())
                    .addToBackStack(AboutFragment.javaClass.simpleName)
                    .commit()
            }
        }

        imageView3.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                    .add(R.id.container, ContactFragment.newInstance()).addToBackStack(ContactFragment.javaClass.simpleName)
                    .commit()
            }
        }

    }

}
