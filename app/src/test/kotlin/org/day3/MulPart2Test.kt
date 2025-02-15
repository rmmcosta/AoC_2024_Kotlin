package org.day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MulPart2Test {

    @Test
    fun parseMul() {
        val rawText = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        val expected = listOf(2 to 4, 8 to 5)
        assertEquals(expected, MulPart2.parseMul(rawText))
    }

    @Test
    fun calcResult() {
        val rawText = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        val expected = 48
        assertEquals(expected, MulPart2.calcResult(rawText))
    }
}