package com.vijayaneraye.intoperation

class StringCalculator {
    fun add( values:String ) :Int {
        val numbers =values.split(",","|")
        if(numbers.isEmpty() ) return -1
        val intValues = numbers.map { it.toInt() }
        return intValues.filter { it !=10 }.fold(0) { acc, number -> acc + number}
    }



}
