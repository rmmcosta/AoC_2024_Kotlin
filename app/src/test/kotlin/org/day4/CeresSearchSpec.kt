package org.day4

import kotlin.test.Test
import kotlin.test.assertEquals

class CeresSearchSpec {
    @Test
    fun `given multiple lines of text with 1 XMAS word and 1 SAMX word, when calling the xmasFinder, then the number 2 should be returned`() {
        val input = """
            ......
            .SAMX.
            ......
            XMAS..
            ......
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(2, result)
    }

    @Test
    fun `given multiple lines of text with 2 XMAS words, when calling the xmasFinder, then the number 2 should be returned`() {
        val input = """
            ......
            .XMAS.
            ......
            XMAS..
            ......
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(2, result)
    }

    @Test
    fun `given multiple lines of text with no XMAS words, when calling the xmasFinder, then the number 0 should be returned`() {
        val input = """
            ......
            ......
            ......
            ......
            ......
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(0, result)
    }

    @Test
    fun `given multiple lines of text with 1 XMAS word in a column, when calling the xmasFinder, then the number 1 should be returned`() {
        val input = """
            ......
            .S....
            .A....
            .M....
            .X....
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(1, result)
    }

    @Test
    fun `given multiple lines of text with 1 XMAS word in a diagonal, when calling the xmasFinder, then the number 1 should be returned`() {
        val input = """
            X.....
            .M....
            ..A...
            ...S..
            ......
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(1, result)
    }

    @Test
    fun `given multiple lines of text with 1 XMAS word in another diagonal, when calling the xmasFinder, then the number 1 should be returned`() {
        val input = """
            .....S
            ....A.
            ...M..
            ..X...
            ......
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(1, result)
    }

    @Test
    fun `given only diagonals input, when calling the xmasFinder, then the number 7 should be returned`() {
        val input = """
            S.S.S.S.S.
            .A.A.A.A..
            ..M.M.M.M.
            .X.X.X.X.X
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(7, result)
    }

    @Test
    fun `given more diagonals input, when calling the xmasFinder, then the number 10 should be returned`() {
        val input = """
            ....X.....
            .....M....
            ...S..A...
            ..A.A..S.X
            .M...M..M.
            X.....XA..
            S.S.S.S.S.
            .A.A.A.A..
            ..M.M.M.M.
            .X.X.X...X
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(10, result)
    }

    @Test
    fun `given 1 simple diagonal, when calling the xmasFinder, then the number 1 should be returned`() {
        val input = """
            .X...
            ..M..
            ...A.
            ....S
         """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(1, result)
    }

    @Test
    fun `given 2 simple diagonals, when calling the xmasFinder, then the number 2 should be returned`() {
        val input = """
            ....X.....
            .....M....
            ...S..A...
            ....A..S..
            .....M....
            ......X...
         """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(2, result)
    }

    @Test
    fun `given the ultimate input, when calling the xmasFinder, then the number 18 should be returned`() {
        val input = """
            ....XXMAS.
            .SAMXMS...
            ...S..A...
            ..A.A.MS.X
            XMASAMX.MM
            X.....XA.A
            S.S.S.S.SS
            .A.A.A.A.A
            ..M.M.M.MM
            .X.X.XMASX
        """.trimIndent()

        val result = xmasFinder(input)

        assertEquals(18, result)
    }
}
