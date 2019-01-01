package com.vijayaneraye.string

import org.junit.Assert.assertEquals
import org.junit.Test

class StringOperationTest {

    @Test
    fun `test rever "Hello" string using operateString function` () {
        val result = StringOpenation().operateString("hello",{it.reversed()})
        assertEquals(result,"olleh")
    }

    @Test
    fun `upper case "Hello" string using operateString function` () {
        val result = StringOpenation().operateString("hello"){it.toUpperCase()}
        assertEquals("HELLO",result)

    }

    @Test
    fun `trasnform string to capitalization` () {
        val result = StringOpenation().transform("hello world",StringOpenation().capitalize)
        assertEquals("Hello world",result)
    }


    @Test
    fun `trasnform string to do nothing` () {
        val result = StringOpenation().transform("Greeting",MyUtils::doNothing)
        assertEquals("Greeting",result)
    }

    @Test
    fun `trasnform string to upper case` () {
        val result = StringOpenation().transform("Hello World",Transformer()::upperCased)
        assertEquals("HELLO WORLD",result)
    }

    @Test
    fun `trasnform string to lower case` () {
        val result = StringOpenation().transform("Hello World",Transformer.Companion::lowerCased)
        assertEquals("hello world",result)
    }


}
