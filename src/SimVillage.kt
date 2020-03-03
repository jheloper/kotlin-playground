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

    // 함수 타입도 타입 추론이 가능하므로 아래와 같이 선언할 수 있다.
    val greetingFunction5 = { playerName: String, numBuildings: Int ->
        val currentYear = 2020
        println("$numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction5("Jane", 5))

    runSimulation("Kim", greetingFunction5)

    // 단축 문법으로 아래와 같이 람다를 전달할 수 있다.
    // 이 방법은 람다가 마지막 인자로 함수에 전달될 때만 가능.
    runSimulation("Lee") { playerName: String, numBuildings: Int ->
        val currentYear = 2020
        println("$numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

// 함수를 인자로 받는 함수.
fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}