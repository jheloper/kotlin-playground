package playground

fun callSimVillage() {

    greetingSimVillage()

    greetingSimVillageAssignedVariable()

    greetingSimVillageWithParameter()

    greetingSimVillageWithItKeyword()

    greetingSimVillageWithParameters()

    greetingSimVillageWithTypeInference()

    val greetingFunction = greetingSimVillageWithTypeInference()

    runSimulation(
        "Kim",
        ::printConstructionCost, // 함수 참조를 인자로 넘길 수 있다.
        greetingFunction
    )

    // 단축 문법으로 아래와 같이 람다를 전달할 수 있다.
    // 이 방법은 람다가 마지막 인자로 함수에 전달될 때만 가능.
    runSimulation(
        "Lee",
        ::printConstructionCost // 함수 참조를 인자로 넘길 수 있다.
    ) { playerName: String, numBuildings: Int ->
        val currentYear = 2020
        println("$numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation2()
}

fun greetingSimVillage() {
    // 익명 함수를 선언하고 호출.
    println({
        val currentYear = 2020
        "Welcome to SimVillage, chief! (copyright $currentYear)"
    }())
}

fun greetingSimVillageAssignedVariable() {
    // 익명 함수를 변수에 지정.
    val greetingFunction: () -> String = {
        // 익명 함수는 암시적 반환이기 때문에 return 키워드를 생략한다.
        val currentYear = 2020
        "This village is SimVillage! (copyright $currentYear)"
    }
    println("greetingFunction variable type is '$greetingFunction'")
    println(greetingFunction())
}

fun greetingSimVillageWithParameter() {
    // 인자 있는 익명 함수.
    val greetingFunction: (String) -> String = {
            playerName ->
        val currentYear = 2020
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction("Tommy"))
}

fun greetingSimVillageWithItKeyword() {
    // it 키워드로 인자를 받는 익명 함수.
    // it 키워드는 하나의 인자를 받을 때에만 사용할 수 있다.
    val greetingFunction: (String) -> String = {
        val currentYear = 2020
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingFunction("Helen"))
}

fun greetingSimVillageWithParameters() {
    // 여러 인자를 받는 익명 함수.
    val greetingFunction: (String, Int) -> String = {
            playerName, numBuildings ->
        val currentYear = 2020
        println("$numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction("John", 3))
}

fun greetingSimVillageWithTypeInference(): (String, Int) -> String {
    // 함수 타입도 타입 추론이 가능하므로 아래와 같이 선언할 수 있다.
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2020
        println("$numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    return greetingFunction
}

// 함수를 인자로 받는 함수.
// inline 키워드를 사용하면 람다가 객체로 전달되지 않고 람다의 코드가 복사되어 삽입된다.
inline fun runSimulation(playerName: String,
                         costPrinter: (Int) -> Unit, // 함수 참조를 인자로 받도록 추가.
                         greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("building cost: ${cost * numBuildings}")
}

fun runSimulation2() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Celine"))
    println(greetingFunction("Celine"))
}

// 함수를 반환하는 함수 선언
fun configureGreetingFunction(): (String) -> String {
    val structureType = "Hospital"
    var numBuildings = 5
    // 코틀린의 람다는 클로저이기 때문에 아래처럼 외부 함수에 선언된 매개변수 및 변수를 사용할 수 있다.
    return {
        playerName: String ->
        val currentYear = 2020
        numBuildings += 1
        println("$structureType types $numBuildings buildings added")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}