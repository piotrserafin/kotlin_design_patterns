package behavioral

/**
 * Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate
 + class, and make their objects interchangeable.
 *
 *
 *  +----------------+
 *  |     Context    |         +---------------+
 *  +----------------+         | <<interface>> |
 *  |- strategy      |<>------>|   Strategy    |
 *  +----------------+         +---------------+
 *  |+ doSomething() |         |+ invoke(data) |
 *  +----------------+         +---------------+
 *       ^                             ^
 *       |                             .
 *       |                             .
 *       |                             .
 *       |                     +--------------------+\
 *  +--------+                 | ConcreteStrategies | |
 *  | Client |---------------->+--------------------+ |
 *  +--------+                 +--------------------+ |
 *                             |+ invoke(data)      | |
 *                             +--------------------+ |
 +                              \+--------------------+
 *
 *
 */


/*** Standard (Java) Approach ***/

interface StdStrategy {
    fun invoke(data: String)
}

class StdConcreteStrategy1: StdStrategy {
    override fun invoke(data: String) {
        println("StdConcreteStrategy1::invoke($data)")
    }
}

class StdConcreteStrategy2: StdStrategy {
    override fun invoke(data: String) {
        println("StdConcreteStrategy2::invoke($data)")
    }
}

class StdContext(var data: String, var strategy: StdStrategy) {
    fun doSomething() {
        strategy.invoke(data)
    }
}

fun standardWay() {

    println("Standard Way")

    val data = "Standard Strategy Pattern"
    val context = StdContext(data, StdConcreteStrategy1())
    context.doSomething()

    context.strategy = StdConcreteStrategy2()
    context.doSomething()
}

/*** Kotlin Approach ***/

typealias KtStrategy = (String) -> Unit

class KtContext(var data: String, var ktStrategy: KtStrategy) {
    fun doSomething() = ktStrategy.invoke(data)
}

val ktConcreteStrategy1 = { data: String -> println("ktConcreteStrategy1::invoke($data)")}
val ktConcreteStrategy2 = { data: String -> println("ktConcreteStrategy2::invoke($data)")}

fun kotlinWay() {

    println("Kotlin Way")

    val data = "Kotlin Strategy Pattern"
    val kotlinContext = KtContext(data, ktConcreteStrategy1)
    kotlinContext.doSomething()

    kotlinContext.ktStrategy = ktConcreteStrategy2
    kotlinContext.doSomething()
}

/*** Client ***/

fun main (args: Array<String>) {
    standardWay()
    kotlinWay()
}