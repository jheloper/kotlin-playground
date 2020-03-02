/**
 * @author joonghyeon.kim
 */
import Color.*

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
    var mutableVariable = "this is"
    mutableVariable = mutableVariable + " mutable variable"
    println(mutableVariable)

    val message: String;
    if (anotherAnswer > 40) {
        message = "success"
    } else {
        message = "fail"
    }

    val name = if (args.size > 0) args[0] else "Kotlin"
    // 아래와 같이 문자열 템플릿 사용 가능
    println("Hello, $name")
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")

    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)

    // var 프로퍼티이기 때문에 아래처럼 값을 set할 수 있다.
    person.isMarried = false
    println(person.isMarried)

    val rectangle1 = Rectangle(100, 100)
    println("rectangle's height is ${rectangle1.height}, width is ${rectangle1.width}")
    println(rectangle1.isSquare)

    val rectangle2 = Rectangle(100, 130)
    println("rectangle's height is ${rectangle2.height}, width is ${rectangle2.width}")
    println(rectangle2.isSquare)

    println(Color.BLUE.rgb())
    println(genMnemonic(Color.BLUE))
    println(getWarmth(Color.ORANGE))
    println(mix(BLUE, YELLOW))
    println(mixOptimized(BLUE, YELLOW))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println("FizzBuzz game 1 to 100")
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    println("\nFizzBuzz game 100 to 1 only even")
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    println("\nFizzBuzz game 1 to 99")
    for (i in 1 until 100) {
        print(fizzBuzz(i))
    }
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

// 기본적인 클래스 선언
class Person(
    val name: String, // 읽기 전용 프로퍼티
    var isMarried: Boolean // 읽기, 쓰기 전부 가능한 프로퍼티
)

// 커스텀 getter 정의
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

// enum 선언
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

// when 문법
fun genMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vain"
}

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw Exception("Dirty color")
}

// 인자 없는 when
fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
    (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
    (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
    else -> throw Exception("Dirty color")
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// is 키워드는 타입 검사 & 스마트 캐스트, as 키워드는 명시적 타입 캐스트
fun eval(e: Expr): Int = when (e) {
    is Num -> {
        println("num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = eval(e.left)
        val right = eval(e.right)
        println("sum: $left + $right")
        left + right
    }
    else -> throw IllegalArgumentException("Unknown expression")
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}