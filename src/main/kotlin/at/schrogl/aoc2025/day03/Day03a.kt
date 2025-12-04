package at.schrogl.aoc2025.day03

import kotlin.math.max

private const val SAMPLE_INPUT = "day03_sample.txt"
private const val ASSIGNMENT_INPUT = "day03_1_assignment.txt"

class Day03a {

    fun run() {
        Day03a::class.java.getResourceAsStream(ASSIGNMENT_INPUT)?.use { file ->
            file.bufferedReader().readLines().sumOf { line ->
                val array = line.map { it.digitToInt() }.toIntArray()
                val idxMax = array.indexOf(array.max())
                val left = if (idxMax == 0) array[idxMax] else "${array.copyOfRange(0, idxMax).max()}${array[idxMax]}".toInt()
                val right = if (idxMax == array.lastIndex) array[idxMax] else "${array[idxMax]}${array.copyOfRange(idxMax + 1, array.size).max()}".toInt()
                max(left.toLong(), right.toLong())
            }.also(::println)
        }
    }
}

fun main(args: Array<String>) {
    Day03a().run()
}
