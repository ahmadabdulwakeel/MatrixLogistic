package com.matrixlogistic.ui.main

import com.matrixlogistic.dto.TrackingList
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.matrixlogistic.R
import kotlinx.android.synthetic.main.shipment_track_item.view.*
import com.matrixlogistic.dto.trackingListCallback
import java.lang.Exception
import android.content.Intent
import android.net.Uri


class TrackingListAdapter :
    ListAdapter<TrackingList, TrackingListAdapter.MyViewHolder>(trackingListCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.shipment_track_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(p0: View?) {
            val trackingList = p0?.tag as TrackingList?
            if (trackingList != null && !TextUtils.isEmpty(trackingList.link)) {
                try {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(trackingList.link)
                    p0?.context?.startActivity(i)
                } catch (e: Exception) {
                }
            }
        }

        fun bind(trackingList: TrackingList) {
            itemView.txtStatus.tag = trackingList
            itemView.txtStatus.setOnClickListener(this)
            itemView.txtStatus.text = trackingList.status
            itemView.txtDate.text = trackingList.h_Date
            itemView.txtLocation.text = trackingList.location
            itemView.txtTime.text = trackingList.h_Time
            itemView.txtPieces.text = trackingList.pieces.toString()
        }
    }
}