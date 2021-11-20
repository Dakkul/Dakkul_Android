package com.example.dakkul.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BaseUrl = "https://asia-northeast3-dakkul-bd6c8.cloudfunctions.net"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkhttpClient())
            .build()
    }

    private fun getOkhttpClient() = OkHttpClient.Builder().apply {
        addInterceptor(getLoggingInterceptor())
    }.build()

    private fun getLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }


    val dakkulAPI: DakkulAPI = getRetrofit().create(DakkulAPI::class.java)

}