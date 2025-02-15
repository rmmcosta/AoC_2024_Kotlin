package org.day3

object MulPart2 {
    fun parseMul(rawText: String): List<Pair<Int, Int>> {
        val matches = Regex("mul\\(([0-9]{1,3})\\,([0-9]{1,3})\\)|(do\\(\\))|(don\\'t\\(\\))").findAll(rawText)
        var isDo = true
        val mults: MutableList<Pair<Int, Int>> = mutableListOf()
        matches.forEach {
            val groups = it.destructured.toList()
            isDo = when {
                groups.contains("don't()") -> false
                groups.contains("do()") -> true
                else -> isDo
            }
            if (isDo) {
                val (value1, value2) = it.destructured
                if (value1.isNotBlank() && value2.isNotBlank())
                    mults.add(value1.toInt() to value2.toInt())
            }
        }
        return mults
    }

    fun calcResult(rawText: String): Int =
        parseMul(rawText).fold(0) { acc, (value1, value2) -> acc + (value1 * value2) }
}

fun main() {
    val rawText = Thread.currentThread().contextClassLoader.getResource("day3/data_day3.txt")?.readText() ?: ""
    //val rawText = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
    //MulPart2.parseMul(rawText)
    println(MulPart2.calcResult(rawText))
}