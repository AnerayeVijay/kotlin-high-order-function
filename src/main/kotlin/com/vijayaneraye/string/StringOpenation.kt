package com.vijayaneraye.string

class StringOpenation {

    fun operateString(str: String, fn: (String) ->String) : String {
        return fn(str)
    }

    val capitalize = { str: String -> str.capitalize() }

    val reverseString = { t: String -> t.reversed()}



    fun <T> transform(input: T,fn : (T) -> T) :T {
        return fn(input)
    }

}

object MyUtils {
    fun doNothing(str: String): String { return str }
}

class Transformer {
    fun upperCased(str: String): String {
        return str.toUpperCase() }
    companion object {
        fun lowerCased(str: String): String {
            return str.toLowerCase() }
    } }