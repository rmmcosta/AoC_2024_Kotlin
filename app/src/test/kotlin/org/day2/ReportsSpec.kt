package org.day2

import kotlin.test.Test
import kotlin.test.assertEquals

class ReportsSpec {
    @Test
    fun `given a string with 6 reports with 5 levels each, when parsing to a list of reports, then it should parse ok`() {
        //given
        val reports =
            """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimEnd()

        //when
        val result = Report.parseFromString(reports)

        //then
        val expected = listOf(
            Report(
                listOf(
                    7, 6, 4, 2, 1
                )
            ), Report(
                listOf(
                    1, 2, 7, 8, 9
                )
            ), Report(
                listOf(
                    9, 7, 6, 2, 1
                )
            ), Report(
                listOf(
                    1, 3, 2, 4, 5
                )
            ), Report(
                listOf(
                    8, 6, 4, 4, 1
                )
            ), Report(
                listOf(
                    1, 3, 6, 7, 9
                )
            )
        )

        assertEquals(expected, result)
    }
}