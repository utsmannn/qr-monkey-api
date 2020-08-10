# QrCode Monkey API Helper

![](https://i.ibb.co/BNN6gK1/Screenshot-2020-08-10-at-6.png)

[ ![Download](https://api.bintray.com/packages/kucingapes/utsman/com.langitpay.helper/images/download.svg) ](https://bintray.com/kucingapes/utsman/com.langitpay.helper/_latestVersion)
### Download
```groovy
// root gradle
allprojects {
    repositories {
        // other
        maven { url = "https://dl.bintray.com/kucingapes/utsman" }
    }
}

// module gradle
implementation 'com.langitpay.helper:qr-monkey-api:1.0.1'
```

### How to use
```kotlin
val apiKey = "api-key"
val qrMonkey = QrMonkey(activity, apiKey, object : QrListener {
    override fun onSuccess(bitmap: Bitmap) {
        // bitmap loaded
    }

    override fun onFailure(throwable: Throwable) {
        // error log
    }
})

val logoUrl = "https://i.ibb.co/ckZ1Yvw/Logo-BG-Putih-01.png"
val simpleBody = simpleBody {
    data = "your data"
    logo = "your logo url"
}

qrMonkey.generate(simpleBody)
```

---