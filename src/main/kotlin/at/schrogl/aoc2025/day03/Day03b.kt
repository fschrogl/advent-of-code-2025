package at.schrogl.aoc2025.day03

private const val SAMPLE_INPUT = "day03_sample.txt"
private const val ASSIGNMENT_INPUT = "day03_1_assignment.txt"

class Day03b {

    fun run() {
        Day03b::class.java.getResourceAsStream(SAMPLE_INPUT)?.use { file ->
            file.bufferedReader().readLines().sumOf { line ->
                var intsList = line.map { it.digitToInt() }
                var digitsToDelete = intsList.size - 12

                while (digitsToDelete > 0) {
                    intsList.forEachIndexed { index, digit ->
                        if (index < intsList.size - 1) {
                            intsList[index] = digit
                        } else {
                            intsList = intsList.dropLast(1)
                        }
                        digitsToDelete--
                    }
                }
                intsList.joinToString().toLong()
            }.also(::println)
        }
    }
}

fun main(args: Array<String>) {
    Day03b().run()
}
