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

    // 인자 있는 익명 함수.
    val greetingFunction2: (String) -> String = {
        playerName ->
        val currentYear = 2020
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction2("Tommy"))

    // it 키워드로 인자를 받는 익명 함수.
    // it 키워드는 하나의 인자를 받을 때에만 사용할 수 있다.
    val greetingFunction3: (String) -> String = {
        val currentYear = 2020
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingFunction3("Helen"))

    // 여러 인자를 받는 익명 함수.
    val greetingFunction4: (String, Int) -> String = {
        playerName, numBuildings ->
        val currentYear = 2020
        println("$numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction4("John", 3))
}