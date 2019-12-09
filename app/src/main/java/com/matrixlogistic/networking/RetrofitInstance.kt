package com.matrixlogistic.networking

import com.matrixlogistic.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {
    private val retroFit: Retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("http://app.matrixlogistic.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build())
        .build()

    public fun getTrackingAPI() : MatrixLogisticService{
        return retroFit.create(MatrixLogisticService::class.java)
    }
}