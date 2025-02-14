package org.day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MulTest {

    @Test
    fun parseMul() {
        val rawText = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val expected = listOf(2 to 4, 5 to 5, 11 to 8, 8 to 5)
        assertEquals(expected, Mul.parseMul(rawText))
    }

    @Test
    fun calcResult() {
        val rawText = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val expected = 161
        assertEquals(expected, Mul.calcResult(rawText))
    }
}