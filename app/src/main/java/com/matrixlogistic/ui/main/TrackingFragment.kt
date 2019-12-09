package com.matrixlogistic.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.matrixlogistic.R
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*
import android.app.Activity
import android.view.inputmethod.InputMethodManager


class TrackingFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        trackTil.editText?.let { hideKeyboardFrom(it) }
        if (TextUtils.isEmpty(trackEt.text))
            trackTil.error = "Please enter tracking id"
        else {
            progress_circular.visibility = View.VISIBLE
            viewModel.fetchOrderDetail(trackTil.trackEt.text.toString())
        }
    }

    companion object {
        fun newInstance() = TrackingFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        viewModel.orderDetail.observe(this, Observer {
            progress_circular.visibility = View.GONE
            activity?.let {
                it.supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
                    .add(R.id.container, DetailFragment.newInstance()).addToBackStack(DetailFragment.javaClass.simpleName)
                    .commit()
            }

        })
        viewModel.apiError.observe(this, Observer {
            progress_circular.visibility = View.GONE
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
        btnTrack.setOnClickListener(this)
    }

    fun hideKeyboardFrom( view: View) {
        try {
            val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }catch (e: Exception){}
    }

}
