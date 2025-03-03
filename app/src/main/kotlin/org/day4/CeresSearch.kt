package org.day4

val BIDIRECTIONAL_XMAS_PATTERNS = setOf("(xmas)", "(XMAS)", "(samx)", "(SAMX)")

fun xmasFinder(input: String): Int {
    val bidirectionalPattern = Regex(BIDIRECTIONAL_XMAS_PATTERNS.joinToString("|"))
    val lines = input.lines().filter { it.trim().isNotBlank() }
    if (lines.isEmpty()) return 0
    val lineSize = lines[0].length
    val columns = (0 until lineSize).map { i ->
        buildString(lineSize) {
            lines.forEach { line ->
                append(line[i])
            }
        }
    }

    ////println("diagonalsCoordinates: $diagonalsCoordinates")
    //val diagonals = diagonalsCoordinates.map { diagonal ->
    //    //println("diagonal: $diagonal")
    //    buildString {
    //        diagonal.forEach { (x, y) ->
    //            append(lines[x][y])
    //        }
    //    }
    //}.toSet()
    println("lines: $lines")
    println("columns: $columns")
    val sumOfLines = lines.sumOf { countFindings(BIDIRECTIONAL_XMAS_PATTERNS, it) }
    println("#lines = $sumOfLines")
    val sumOfColumns = columns.sumOf { countFindings(BIDIRECTIONAL_XMAS_PATTERNS, it) }
    println("#columns = $sumOfColumns")
    val sumOfDiagonals = sumDiagonals(lines, lineSize)
    println("#diagonals = $sumOfDiagonals")
    return sumOfLines + sumOfColumns + sumOfDiagonals
}

private fun countFindings(pattern: Set<String>, text: String): Int = try {
    val patternSize = 4
    val textSize = text.length
    var countMatches = 0
    (0..textSize - patternSize).forEach { i ->
        val word = text.substring(i, patternSize + i)
        if (pattern.contains("($word)")) countMatches += 1
    }
    countMatches
} catch (e: Exception) {
    0
}

private fun patternMatches(lines: List<String>, coordinates: List<Pair<Int, Int>>, pattern: Set<String>): Boolean {
    if (pattern.isEmpty()) return false
    val wordSize = pattern.first().length
    val word = buildString(wordSize) {
        coordinates.forEach { (x, y) ->
            append(lines[x][y])
        }
    }
    return pattern.contains("($word)")
}

private fun sumDiagonals(lines: List<String>, lineSize: Int): Int {
    val patternSize = 4
    val diagonalsCoordinates = diagonals(lines.size - 1, lineSize - 1, patternSize)
    val matchingCoordinates: MutableList<Set<Pair<Int, Int>>> = mutableListOf()
    diagonalsCoordinates.forEach { diagonal ->
        val diagonalSize = diagonal.size
        (0..diagonalSize - patternSize).forEach { i ->
            val subCoordinates = diagonal.subList(i, patternSize + i)
            if (patternMatches(lines, subCoordinates, BIDIRECTIONAL_XMAS_PATTERNS)) {
                val matching = subCoordinates.toSet()
                if (!matchingCoordinates.contains(matching)) matchingCoordinates.add(matching)
            }
        }
    }
    println("matching coordinates: $matchingCoordinates")
    return matchingCoordinates.size
}

fun main() {
    val input = Thread.currentThread().contextClassLoader.getResource("day4/data_day4.txt")?.readText() ?: ""
    println("result: ${xmasFinder(input)}")
}
