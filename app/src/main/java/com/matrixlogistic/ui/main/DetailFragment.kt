package com.matrixlogistic.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.matrixlogistic.R
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.detail_fragment.view.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*

class DetailFragment : Fragment() {
    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        viewModel.orderDetail.observe(this, Observer { apiResponse ->
            val order = apiResponse.order
            txtTrackingNo.text = viewModel.trackingNo

            if (apiResponse.trackingList != null && apiResponse.trackingList.isNotEmpty())
                txtCurrentStatus.text = apiResponse.trackingList.last().status
            txtConsignee.text = order.consignee_ReceiverNameAddress
            txtShipper.text = order.shipper_SenderNameAddress
            txtCarrier.text = order.carrier
            txtPortofLanding.text = order.portOfLanding
            txtPortofDelivery.text = order.protOfDeliver
            txtMBL.text = order.mBL_Container_Number
            txtHAWB.text = order.hBL
            txtCommodity.text = order.commodity
            txtEquipmentCount.text = order.numberOfEquipments
            txtWeight.text = order.weight
            txtVolume.text = order.volume
            txtVesselNname.text = order.vesselNameAndVOY
            txtCOD.text = order.cOD
            txtETD.text = order.eTD
            txtETA.text = order.eTA
            txtHBL.text = order.hBL
            txtMAWB.text = order.mAWB

            activity?.let { fragmentActivity ->
                val itemDecorator = DividerItemDecoration(fragmentActivity, DividerItemDecoration.VERTICAL)
                itemDecorator.setDrawable(ContextCompat.getDrawable(fragmentActivity, R.drawable.divider)!!)
                trackList.addItemDecoration(itemDecorator)
            }
            val trackingListAdapter = TrackingListAdapter()
            trackList.adapter = trackingListAdapter
            trackingListAdapter.submitList(apiResponse.trackingList)

        })
    }

}
