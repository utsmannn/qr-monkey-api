package com.langitpay.helper.qrmonkey

fun simpleBody(body: SimpleBody.() -> Unit) : SimpleBody {
    val sBody = SimpleBody()
    sBody.apply(body)
    return sBody
}

object BODY {
    val square = "square"
    val circle = "circle"
    val japnese = "japnese"
    val round = "round"
    val dot = "dot"
}

object EYE {
    val frame0 = "frame0"
    val frame1 = "frame1"
    val frame2 = "frame2"
    val frame3 = "frame3"
    val frame4 = "frame4"
    val frame5 = "frame5"
    val frame6 = "frame6"
}

object EYE_BALL {
    val ball0 = "ball0"
    val ball1 = "ball1"
    val ball2 = "ball2"
    val ball3 = "ball3"
    val ball4 = "ball4"
    val ball5 = "ball5"
    val ball6 = "ball6"
}