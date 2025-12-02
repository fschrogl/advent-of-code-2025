package at.schrogl.aoc2025.day01

private const val SAMPLE_INPUT = "day01_1_sample.txt"
private const val ASSIGNMENT_INPUT = "day01_1_assignment.txt"

class Day01a {

    private val minimumValue = 0
    private val maximumValue = 99
    private val startingValue = 50

    fun run() {
        var result = 0
        var currentValue = startingValue
        Day01a::class.java.getResourceAsStream(ASSIGNMENT_INPUT)?.use {
            it.bufferedReader().forEachLine { command ->
                when (command.take(1)) {
                    "L" -> currentValue -= command.drop(1).toInt()
                    "R" -> currentValue += command.drop(1).toInt()
                }
                while (currentValue > maximumValue) currentValue -= 100
                while (currentValue < minimumValue) currentValue += 100
                if (currentValue == 0) result++
            }
        }
        println("Result Day01a: $result")
    }
}

fun main(args: Array<String>) {
    Day01a().run()
}
