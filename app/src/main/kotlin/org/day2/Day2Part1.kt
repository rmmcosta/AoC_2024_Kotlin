package org.day2

class Day2Part1 {
    fun calculateSafeLevels(reports: String): Int {
        if (reports.isBlank()) return 0
        val parsedReports: List<Report> = Report.parseFromString(reports)
        return parsedReports.count(::isReportSafe)
    }

    private fun isReportSafe(report: Report): Boolean =
        areAllLevelsIncreasing(report.levels) || areAllLevelsDecreasing(report.levels)

    private fun areAllLevelsIncreasing(levels: List<Int>): Boolean =
        levels.zipWithNext().all { (l1, l2) -> (l2 - l1) in 1..3 }

    private fun areAllLevelsDecreasing(levels: List<Int>): Boolean =
        levels.zipWithNext().all { (l1, l2) -> (l1 - l2) in 1..3 }
}

data class Report(val levels: List<Int>) {
    companion object {
        fun parseFromString(stringReports: String): List<Report> = parseReports(stringReports.trim().split("\n"))

        private fun parseReports(lines: List<String>): List<Report> = lines.map { parseLevels(it) }

        private fun parseLevels(line: String): Report = Report(line.trim().split(" ").map { it.toInt() })
    }
}

fun main() {
    val rawReport: String =
        Thread.currentThread().contextClassLoader.getResourceAsStream("day2/data_day2.txt")?.bufferedReader()?.readText()
            ?: ""
    println("result: ${Day2Part1().calculateSafeLevels(rawReport)}")
}
