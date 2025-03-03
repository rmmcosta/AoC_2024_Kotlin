package org.day4

import kotlin.test.Test
import kotlin.test.assertEquals

class DiagonalsSpec {
    @Test
    fun `given a 2x2 rectangle, when calling the diagonals of size 1, then the correct coordinates should be returned`() {
        val (x, y, z) = listOf(2, 2, 1)
        val expected = listOf(
            listOf(2 to 0),
            listOf(2 to 1),
            listOf(2 to 2),
            listOf(1 to 0, 2 to 1),
            listOf(1 to 1, 2 to 2),
            listOf(1 to 2),
            listOf(0 to 0, 1 to 1, 2 to 2),
            listOf(0 to 1, 1 to 2),
            listOf(0 to 2),
            listOf(2 to 2),
            listOf(2 to 1, 1 to 2),
            listOf(2 to 0, 1 to 1, 0 to 2),
            listOf(1 to 2),
            listOf(1 to 1, 0 to 2),
            listOf(1 to 0, 0 to 1),
            listOf(0 to 1),
            listOf(0 to 0)
        )

        val result = diagonals(x, y, z)

        assertEquals(expected, result)
    }

    @Test
    fun `given a 1x1 rectangle, when calling the diagonals of size 3, then the correct coordinates should be returned`() {
        val (x, y, z) = listOf(1, 1, 3)
        val expected = 0

        val result = diagonals(x, y, z).size

        assertEquals(expected, result)
    }

    @Test
    fun `given a 4x3 rectangle, when calling the diagonals of size 2, then the correct coordinates should be returned`() {
        val (x, y, z) = listOf(4, 3, 2)
        val expected = 8

        val result = diagonals(x, y, z).size

        assertEquals(expected, result)
    }
}