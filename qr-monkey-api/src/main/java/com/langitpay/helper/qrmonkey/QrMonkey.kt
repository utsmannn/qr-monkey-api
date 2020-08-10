package com.langitpay.helper.qrmonkey

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Suppress("BlockingMethodInNonBlockingContext")
class QrMonkey(private val activity: Activity, private val apiKey: String, private val listener: QrListener) {

    fun generate(simpleBody: SimpleBody) {
        GlobalScope.launch {
            try {
                val response = Network.create(
                    apiKey
                ).custom(simpleBody.toRequestBody())
                val bytes = response.bytes()
                val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                activity.runOnUiThread {
                    listener.onSuccess(bitmap)
                }
            } catch (e: Throwable) {
                activity.runOnUiThread {
                    listener.onFailure(e)
                }
            }
        }
    }
}

interface QrListener {
    fun onSuccess(bitmap: Bitmap)
    fun onFailure(throwable: Throwable)
}