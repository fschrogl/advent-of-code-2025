package at.schrogl.aoc2025.day02

private const val SAMPLE_INPUT = "day02_1_sample.txt"
private const val ASSIGNMENT_INPUT = "day02_1_assignment.txt"

class Day02a {

    fun run() {
        Day02a::class.java.getResourceAsStream(ASSIGNMENT_INPUT)?.use { file ->
            file.bufferedReader().readLines().joinToString { it }
                .splitToSequence(",")
                .flatMap(::computeInvalidIds)
                .sum()
                .also(::println)
        }
    }

    fun computeInvalidIds(range: String): List<Long> =
        range.split("-").let { (min, max) ->
            (min.toLong()..max.toLong())
                .filter {
                    it.toString().matches("(\\d+)\\1".toRegex())
                }
        }
}

fun main(args: Array<String>) {
    Day02a().run()
}
