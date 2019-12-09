package com.matrixlogistic.dto

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class TrackingList(

    @SerializedName("TrackingId") val trackingId: Int,
    @SerializedName("OrderId") val orderId: Int,
    @SerializedName("H_Date") val h_Date: String,
    @SerializedName("H_Time") val h_Time: String,
    @SerializedName("Status") val status: String,
    @SerializedName("Location") val location: String,
    @SerializedName("Link") val link: String,
    @SerializedName("Pieces") val pieces: Int,
    @SerializedName("CreateDate") val createDate: String,
    @SerializedName("ModifiedDate") val modifiedDate: String,
    @SerializedName("CreatedBy") val createdBy: Int,
    @SerializedName("ModifiedBy") val modifiedBy: String,
    @SerializedName("CreatedByName") val createdByName: String,
    @SerializedName("ModifiedByName") val modifiedByName: String,
    @SerializedName("Message") val message: String,
    @SerializedName("ValidationMessage") val validationMessage: ValidationMessage
)

val trackingListCallback: DiffUtil.ItemCallback<TrackingList> =
    object : DiffUtil.ItemCallback<TrackingList>() {

        override fun areItemsTheSame(
            oldItem: TrackingList,
            newItem: TrackingList
        ): Boolean {
            return oldItem.trackingId == newItem.trackingId
        }

        override fun areContentsTheSame(
            oldItem: TrackingList,
            newItem: TrackingList
        ): Boolean {
            return true
        }
    }
