package com.langitpay.qrmonkey.sample

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.langitpay.helper.qrmonkey.QrListener
import com.langitpay.helper.qrmonkey.QrMonkey
import com.langitpay.helper.qrmonkey.simpleBody
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiKey = "api-key"
        val qrMonkey = QrMonkey(this, apiKey, object : QrListener {
            override fun onSuccess(bitmap: Bitmap) {
                image_view.setImageBitmap(bitmap)
                text_log.text = "Success"
            }

            override fun onFailure(throwable: Throwable) {
                text_log.text = throwable.localizedMessage
            }
        })

        val logoUrl = "https://i.ibb.co/ckZ1Yvw/Logo-BG-Putih-01.png"
        val simpleBody = simpleBody {
            data = "081287903894"
            logo = logoUrl
        }

        qrMonkey.generate(simpleBody)
    }
}