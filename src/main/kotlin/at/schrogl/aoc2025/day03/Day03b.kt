package at.schrogl.aoc2025.day03

import kotlin.math.max

private const val SAMPLE_INPUT = "day03_sample.txt"
private const val ASSIGNMENT_INPUT = "day03_2_assignment.txt"

class Day03b {

    fun run() {
        Day03b::class.java.getResourceAsStream(SAMPLE_INPUT)?.use { file ->
            file.bufferedReader().readLines().sumOf { line ->
                val sortedList = line.map { it.digitToInt() }.sorted()
                val digitsToBeRemoved = sortedList.take(sortedList.size - 12)
                var result = line
                digitsToBeRemoved.forEach { result = result.replaceFirst(it.toString(), "")}
                result.toLong()
            }.also(::println)
        }
    }
}

fun main(args: Array<String>) {
    Day03b().run()
}
