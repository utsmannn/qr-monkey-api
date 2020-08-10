package com.langitpay.helper.qrmonkey

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val rapidKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("x-rapidapi-host",
                        host
                    )
                    .addHeader("x-rapidapi-key", rapidKey)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build()
            )
        }
    }
}

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .build()
        request = request.newBuilder().url(url).build()
        val pr = chain.proceed(request)
        val b = pr.body
        Log.d("log", "intercept: -> ${b?.string()}")
        return chain.proceed(request)
    }
}