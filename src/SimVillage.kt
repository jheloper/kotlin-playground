/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    // 익명 함수를 선언하고 호출.
    println({
        val currentYear = 2020
        "Welcome to SimVillage, chief! (copyright $currentYear)"
    }())

    // 익명 함수를 변수에 지정.
    val greetingFunction: () -> String = {
        // 익명 함수는 암시적 반환이기 때문에 return 키워드를 생략한다.
        val currentYear = 2020
        "This village is SimVillage! (copyright $currentYear)"
    }

    println("greetingFunction variable type is '$greetingFunction'")
    println(greetingFunction())
}