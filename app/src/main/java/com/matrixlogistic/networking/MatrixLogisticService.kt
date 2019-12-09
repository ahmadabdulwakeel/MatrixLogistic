package com.matrixlogistic.networking

import com.matrixlogistic.dto.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface MatrixLogisticService {

    @Headers("Accept: application/json")
    @GET("api/order/GetTrackHistory/{trackingID}")
    fun listRepos(@Path("trackingID") trackingID: String): Call<ApiResponse>
}