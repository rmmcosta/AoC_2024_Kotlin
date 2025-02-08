package org.day2

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Part1Spec {
    @Test
    fun `given 6 reports with 5 levels each, when counting the safe levels, then 2 is returned`() {
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

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(2, result)
    }

    @Test
    fun `given 3 reports with 5 levels each, when counting the safe levels, then 1 is returned`() {
        // given
        val reports =
            """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(1, result)
    }

    @Test
    fun `given a report with all levels increasing, when calculating the safe levels, then 1 should be returned`() {
        // given
        val reports =
            """
            1 2 3 4 5
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(1, result)
    }

    @Test
    fun `given a report with all levels decreasing, when calculating the safe levels, then 1 should be returned`() {
        // given
        val reports =
            """
            5 4 3 2 1
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(1, result)
    }

    @Test
    fun `given a report with some levels increasing, when calculating the safe levels, then 0 should be returned`() {
        // given
        val reports =
            """
            3 4 7 2 1
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `given a report with some levels decreasing, when calculating the safe levels, then 0 should be returned`() {
        // given
        val reports =
            """
            5 4 7 2 1
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `given a report with some levels differing by 0, when calculating the safe levels, then 0 should be returned`() {
        // given
        val reports =
            """
            5 4 3 2 2
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `given a report with some levels differing by more than 3, when calculating the safe levels, then 0 should be returned`() {
        // given
        val reports =
            """
            15 14 11 2 1
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `given a report with all levels differing by at least one and at most three, when calculating the safe levels, then 1 should be returned`() {
        // given
        val reports =
            """
            1 3 6 7 10
        """.trimEnd()

        val day2Part1 = Day2Part1()

        // when
        val result = day2Part1.calculateSafeLevels(reports)

        // then
        assertEquals(1, result)
    }
}
