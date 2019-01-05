package com.vijayaneraye

import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionalLiteralTest {

    @Test
    fun `test functional literal` () {
        val result = FunctionalLiteral().greet
        assertEquals("Hello", result)
    }

    @Test
    fun `sum of 1 and 2 using calculation` () {
        val result = FunctionalLiteral().calculator(1,2,FunctionalLiteral().sum)
        assertEquals(2, result)
    }

    @Test
    fun `miltiple of 5 and 4 using calculation` () {
        val result = FunctionalLiteral().calculator(5,4,FunctionalLiteral().multiply)
        assertEquals(2, result)
    }

    @Test
    fun `additing of 10 and 30 using calculation` () {
        val result = FunctionalLiteral().calculator(10,30,FunctionalLiteral().addTwoNum)
        assertEquals(40, result)
    }
}
