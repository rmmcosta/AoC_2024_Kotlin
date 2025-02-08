package org.day2

class Day2Part2 : Day2Part1() {
    override fun isReportSafe(report: Report): Boolean =
        super.isReportSafe(report) || areAllLevelsMinus1Safe(report.levels)

    private fun areAllLevelsMinus1Safe(levels: List<Int>): Boolean = levels.indices.any { index ->
        val subList = levels.subList(0, index) + levels.subList(index + 1, levels.size)
        areAllLevelsIncreasing(subList) || areAllLevelsDecreasing(subList)
    }
}

fun main() {
    val rawReport: String =
        Thread.currentThread().contextClassLoader.getResourceAsStream("day2/data_day2.txt")?.bufferedReader()
            ?.readText()
            ?: ""
    println("result: ${Day2Part2().calculateSafeLevels(rawReport)}")
}
