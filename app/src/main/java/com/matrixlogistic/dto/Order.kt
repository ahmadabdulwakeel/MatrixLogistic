package com.matrixlogistic.dto

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Order (

	@SerializedName("OrderId") val orderId : Int,
	@SerializedName("AirWayBillNumberNumber") val airWayBillNumberNumber : String,
	@SerializedName("Shipper_SenderNameAddress") val shipper_SenderNameAddress : String,
	@SerializedName("Consignee_ReceiverNameAddress") val consignee_ReceiverNameAddress : String,
	@SerializedName("PortOfLanding") val portOfLanding : String,
	@SerializedName("ProtOfDeliver") val protOfDeliver : String,
	@SerializedName("MBL_Container_Number") val mBL_Container_Number : String,
	@SerializedName("AWB_Number_AirWayBill") val aWB_Number_AirWayBill : String,
	@SerializedName("MAWB") val mAWB : String,
	@SerializedName("HBL") val hBL : String,
	@SerializedName("Carrier") val carrier : String,
	@SerializedName("NumberOfEquipments") val numberOfEquipments : String,
	@SerializedName("Commodity") val commodity : String,
	@SerializedName("Weight") val weight : String,
	@SerializedName("Volume") val volume : String,
	@SerializedName("VesselNameAndVOY") val vesselNameAndVOY : String,
	@SerializedName("COD") val cOD : String,
	@SerializedName("ETD") val eTD : String,
	@SerializedName("ETA") val eTA : String,
	@SerializedName("CurrentStatus") val currentStatus : Int,
	@SerializedName("CreateDate") val createDate : String,
	@SerializedName("ModifiedDate") val modifiedDate : String,
	@SerializedName("CreatedBy") val createdBy : Int,
	@SerializedName("ModifiedBy") val modifiedBy : String,
	@SerializedName("CreatedByName") val createdByName : String,
	@SerializedName("ModifiedByName") val modifiedByName : String,
	@SerializedName("ListTracking") val listTracking : String,
	@SerializedName("Message") val message : String,
	@SerializedName("ValidationMessage") val validationMessage : ValidationMessage
)