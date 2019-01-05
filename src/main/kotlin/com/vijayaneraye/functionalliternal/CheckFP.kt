package com.vijayaneraye.functionalliternal

class MyClass {

    val square = {x:Int ->x*x}
    val add5 = {x:Int ->x+5}

    inline fun math(logIt: (MyClass) -> Int) = logIt(this)

}

fun log( t:Int,logIt: (Int) -> String) = logIt(t)

val intValu = 200

fun main(agrs: Array<String>) {
    println(log(5){ (it*2).toString() })
    println(MyClass().math({ intValu}))

}