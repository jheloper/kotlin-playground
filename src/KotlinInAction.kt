/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    println("Hello, world!")
    println(max(1, 3))
    println(maxExpressionBody(7, 3))

    // 변수 선언
    val question: String = "final question"
    // 아래와 같이 타입 표기를 생략할 수 있다, 타입 추론이 가능하기 때문
    val answer = 42

    val yearsToCompute = 7.5e6
    // 아래와 같이 선언과 할당을 별도로 할 경우 타입 표기 필수
    val anotherAnswer: Int
    anotherAnswer = 43

    // val(=value): Immutable, var(=variable): Mutable
    val immutableValue = "this is immutable value"
    var mutableVariable = "this is mutable variable"
}

// 기본적인 함수를 선언하는 방법
fun max(a: Int, b: Int): Int {

    // 코틀린의 if는 expression, statement가 아니다!
    return if (a > b) {
        a
    } else {
        b
    }
}

// expression이 본문인 함수는 아래와 같이 단축하여 선언할 수 있다.
fun maxExpressionBody(a: Int, b: Int) = if (a > b) a else b;