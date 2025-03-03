package org.day4

fun diagonals(x: Int, y: Int, size: Int): List<List<Pair<Int, Int>>> {
    val halfDown: MutableList<List<Pair<Int, Int>>> = mutableListOf()
    (x downTo 0).forEach { x1 ->
        (0..y).forEach { y1 ->
            val pairs: MutableList<Pair<Int, Int>> = mutableListOf()
            (x1..x).forEach { x2 ->
                (0..y).forEach { y2 ->
                    if ((x == 0 && ((y2 - x2) == (y1 - x1))) || ((x2 - y2) == (x1 - y1)))
                        pairs.add(x2 to y2)
                }
            }
            if (pairs.isNotEmpty() && !halfDown.contains(pairs) && pairs.size >= size)
                halfDown.add(pairs)
        }
    }
    println("halfDown: $halfDown")

    val halfUp: MutableList<List<Pair<Int, Int>>> = mutableListOf()
    (x downTo 0).forEach { x1 ->
        (y downTo 0).forEach { y1 ->
            val pairs: MutableList<Pair<Int, Int>> = mutableListOf()
            (x1 downTo 0).forEach { x2 ->
                (y1..y).forEach { y2 ->
                    if (x2 + y2 == x1 + y1)
                        pairs.add(x2 to y2)
                }
            }
            if (pairs.isNotEmpty() && !halfUp.contains(pairs) && pairs.size >= size)
                halfUp.add(pairs)
        }
    }
    println("halfUp: $halfUp")

    return halfDown + halfUp
}
