package behavioral

/**
 * State Pattern
 *
 *
 *  +----------------+
 *  |     Context    |         +---------------+
 *  +----------------+         | <<interface>> |
 *  |- state: IState |<>------>|    IState     |
 *  +----------------+         +---------------+
 *  |+ request()     |         |+ handle()     |
 *  +----------------+         +---------------+
 *       ^                             ^
 *       |                             |
 *       |                       ______|_______
 *       |                      |               |
 *       |               +-----------+   +-----------+
 *  +--------+           |  StateA   |   |  StateB   |
 *  | Client |           +-----------+   +-----------+
 *  +--------+           |+ handle() |   |+ handle() |
 *                       +-----------+   +-----------+
 *
 */

/*** Standard (Java) Approach ***/

interface IStdState {
    fun handle(context: StdStateContext, data: String): String
}

class StdStateA: IStdState {
    override fun handle(context: StdStateContext, data: String): String {
        context.state = StdStateB()
        return "StateA - ($data)"
    }
}

class StdStateB: IStdState {
    override fun handle(context: StdStateContext, data: String): String {
        context.state = StdStateA()
        return "StateB - ($data)"
    }
}

class StdStateContext(private val data:String, var state: IStdState) {
    fun request(): String {
        return state.handle(this, data)
    }
}

/*** Kotlin Approach ***/

sealed class KtState

object KtStateA : KtState()
object KtStateB : KtState()

class KtStateContext(private val data: String, var state: KtState) {

    fun request(): String {

        return when (state) {
            is KtStateA -> {
                state = KtStateB
                "StateA - ($data)"
            }
            is KtStateB -> {
                state = KtStateA
                "StateB - ($data)"
            }
        }
    }
}