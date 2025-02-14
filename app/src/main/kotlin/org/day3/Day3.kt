package org.day3

object Mul {
    fun parseMul(rawText: String): List<Pair<Int, Int>> {
        val matches = Regex("mul\\(([0-9]{1,3})\\,([0-9]{1,3})\\)").findAll(rawText)
        return matches.map {
            val (value1, value2) = it.destructured
            value1.toInt() to value2.toInt()
        }.toList()
    }

    fun calcResult(rawText: String): Int =
        parseMul(rawText).fold(0) { acc, (value1, value2) -> acc + (value1 * value2) }
}

fun main() {
    val rawText = Thread.currentThread().contextClassLoader.getResource("day3/data_day3.txt")?.readText() ?: ""
    println(Mul.calcResult(rawText))
}