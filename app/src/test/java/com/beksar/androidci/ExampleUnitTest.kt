package com.beksar.androidci

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        println("OK Test")
    }

    @Test
    fun addition_isCorrect2() {
        assertEquals(4,  2)
        println("Error Test")
    }
}