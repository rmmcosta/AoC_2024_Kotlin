package org.day2

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Part2Spec {
    @Test
    fun `given 6 reports with 5 levels each, when counting the safe levels, then 4 is returned`() {
        // given
        val reports =
            """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimEnd()

        val day2Part2 = Day2Part2()

        // when
        val result = day2Part2.calculateSafeLevels(reports)

        // then
        assertEquals(4, result)
    }
}
