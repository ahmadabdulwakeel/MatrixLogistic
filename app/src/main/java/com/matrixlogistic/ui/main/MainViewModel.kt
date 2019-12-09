package com.matrixlogistic.ui.main

import com.matrixlogistic.dto.ApiResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matrixlogistic.networking.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val orderDetail = MutableLiveData<ApiResponse>()
    val apiError = MutableLiveData<String>()
    var trackingNo = ""
    fun fetchOrderDetail(trackingID: String){
        this.trackingNo = trackingID
        RetrofitInstance.getTrackingAPI().listRepos(trackingID).enqueue(object : Callback<ApiResponse>{
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                apiError.value = t.message
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful){
                    val apiResponse: ApiResponse = response.body()!!
                    if(apiResponse.validationMessage.hasError){
                        apiError.value = apiResponse.validationMessage.errorMessage
                    }
                    else{
                        orderDetail.value = apiResponse
                    }
                }
            }

        })
    }
}
