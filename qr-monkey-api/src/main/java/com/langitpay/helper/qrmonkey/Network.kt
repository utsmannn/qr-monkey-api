package com.langitpay.helper.qrmonkey

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

const val host = "qrcode-monkey.p.rapidapi.com"
private const val baseUrl = "https://qrcode-monkey.p.rapidapi.com"
private const val endPoint = "/qr/custom"

interface Network {
    @POST(endPoint)
    suspend fun custom(
        @Body requestBody: RequestBody
    ): ResponseBody

    companion object {
        fun create(apiKey: String): Network {

            val client = OkHttpClient.Builder()
                .addInterceptor(
                    HeaderInterceptor(
                        apiKey
                    )
                )
                .addInterceptor(NetworkInterceptor())
                .callTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build()

            val gson = GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
            return retrofit.create(Network::class.java)
        }
    }
}