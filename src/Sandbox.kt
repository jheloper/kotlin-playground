/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    println("Run Sandbox!")

    val numLetters = "Mississippi".count()
    println(numLetters)

    val numLettersForS = "Mississippi".count({
            letter -> letter == 's'
    })
    println(numLettersForS)
}