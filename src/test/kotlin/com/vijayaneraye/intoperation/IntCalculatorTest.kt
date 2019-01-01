package com.vijayaneraye.intoperation

import org.junit.Assert.assertEquals
import org.junit.Test

class IntCalculatorTest {

    @Test
    fun `return same value for single  1` () {
        val result = StringCalculator().add("1")
        assertEquals(result,1)
    }

    @Test
    fun `return same value for 0` () {
        val result = StringCalculator().add("0")
        assertEquals(result,0)
    }

    @Test
    fun `add values using calculator` () {
        val result = StringCalculator().add("1,2")
        assertEquals(3,result)
    }

    @Test
    fun `add values using | deliminator` () {
        val result = StringCalculator().add("1|2")
        assertEquals(3,result)
    }

    @Test
    fun `add four values using , and | deliminator` () {
        val result = StringCalculator().add("1|2|3,4,5")
        assertEquals(15,result)
    }

    @Test
    fun `not to add 10 values using , and | deliminator` () {
        val result = StringCalculator().add("1|2|3,4,5,10")
        assertEquals(15,result)
    }
}