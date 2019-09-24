package behavioral

/**
 * Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate
 + class, and make their objects interchangeable.
 *
 *
 *  +----------------+
 *  |     Context    |         +---------------+
 *  +----------------+         | <<interface>> |
 *  |- strategy      |<>------>|   IStrategy   |
 *  +----------------+         +---------------+
 *  |+ request()     |         |+ handle(data) |
 *  +----------------+         +---------------+
 *       ^                             ^
 *       |                             .
 *       |                             .
 *       |                             .
 *       |                     +--------------------+\
 *  +--------+                 | ConcreteStrategies | |
 *  | Client |---------------->+--------------------+ |
 *  +--------+                 +--------------------+ |
 *                             |+ handle(data)      | |
 *                             +--------------------+ |
 +                              \+--------------------+
 *
 *
 */


/*** Standard (Java) Approach ***/

interface IStdStrategy {
    fun handle(data: String): String
}

class StdStrategyA: IStdStrategy {
    override fun handle(data: String): String {
        return "StrategyA - ($data)"
    }
}

class StdStrategyB: IStdStrategy {
    override fun handle(data: String): String {
        return "StrategyB - ($data)"
    }
}

class StdStrategyContext(private var data: String, var strategy: IStdStrategy) {
    fun request(): String {
        return strategy.handle(data)
    }
}

/*** Kotlin Approach ***/

typealias IKtStrategy = (String) -> String

class KtContext(var data: String, var ktStrategy: IKtStrategy) {
    fun request(): String = ktStrategy.invoke(data)
}

val ktStrategyA = { data: String -> "StrategyA - ($data)"}
val ktStrategyB = { data: String -> "StrategyB - ($data)"}

