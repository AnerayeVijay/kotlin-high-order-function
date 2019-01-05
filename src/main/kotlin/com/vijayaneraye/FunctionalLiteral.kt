package com.vijayaneraye


class FunctionalLiteral {
        val greet = ::greetFunction
    val sum = { x: Int, y: Int -> x + y }

    val multiply = { x: Int, y: Int -> x * y }

    val addTwoNum : (Int,Int) ->Int = {x,y->x+y}

    fun main(args: Array<String>) {
        val reverse: (Int) -> Int//(1)
        //
        reverse = { number ->
            var n = number
            var revNumber = 0
            while (n > 0) {
                val digit = n % 10
                revNumber = revNumber * 10 + digit
                n /= 10
            }
            revNumber
        }// (2)
        println("reverse 123 ${reverse(123)}")
        println("reverse 456 ${reverse(456)}")
        println("reverse 789 ${reverse(789)}")
    }




    var onTitleChanged: ((String, String) -> Unit)? = null


    fun greetFunction() :String {
        return "Hello"
    }

    fun calculator(x:Int,y:Int, fn:(Int,Int) ->Int ) : Int {
        return fn (x,y)
    }


}


