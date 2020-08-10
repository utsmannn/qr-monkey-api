package com.langitpay.helper.qrmonkey


import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("config")
    var config: Config = Config(),
    @SerializedName("data")
    var `data`: String? = null,
    @SerializedName("download")
    var download: Boolean = false,
    @SerializedName("file")
    var `file`: String = "jpg",
    @SerializedName("size")
    var size: Int = 500
) {
    data class Config(
        @SerializedName("body")
        var body: String? = BODY.square,
        @SerializedName("bodyColor")
        var bodyColor: String = "#000000",
        @SerializedName("eye")
        var eye: String = EYE.frame0,
        @SerializedName("eyeBall")
        var eyeBall: String = EYE_BALL.ball0,
        @SerializedName("eyeBall1Color")
        var eyeBall1Color: String = "#000000",
        @SerializedName("gradientColor1")
        var gradientColor1: String? = null,
        @SerializedName("gradientColor2")
        var gradientColor2: String? = null,
        @SerializedName("gradientOnEyes")
        var gradientOnEyes: Boolean? = false,
        @SerializedName("gradientType")
        var gradientType: String? = null,
        @SerializedName("logo")
        var logo: String? = null,
        @SerializedName("logoMode")
        var logoMode: String = "clean"
    )
}

data class SimpleBody(
    @SerializedName("size")
    var size: Int = 500,
    @SerializedName("data")
    var `data`: String? = null,
    @SerializedName("body")
    var body: String? = BODY.square,
    @SerializedName("bodyColor")
    var bodyColor: String = "#000000",
    @SerializedName("eye")
    var eye: String = EYE.frame0,
    @SerializedName("eyeBall")
    var eyeBall: String = EYE_BALL.ball0,
    @SerializedName("logo")
    var logo: String? = null
) {

    fun toRequestBody(): RequestBody {
        return RequestBody(
            data = this.data,
            size = this.size,
            config = RequestBody.Config(
                body = this.body,
                logo = this.logo,
                eye = this.eye,
                eyeBall = this.eyeBall,
                bodyColor = this.bodyColor
            )
        )
    }
}

