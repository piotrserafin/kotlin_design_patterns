package behavioral

import org.junit.Assert.assertEquals
import org.junit.Test

class StateTest {
    @Test fun `Standard State Pattern`() {
        val testData = "standard"

        val expectedStringFromStateA = "StateA - (standard)"
        val expectedStringFromStateB = "StateB - (standard)"

        val context = StdStateContext(testData, StdStateA())
        assertEquals(expectedStringFromStateA, context.request())
        assertEquals(expectedStringFromStateB, context.request())
        assertEquals(expectedStringFromStateA, context.request())
        assertEquals(expectedStringFromStateB, context.request())
    }

    @Test fun `Kotlin State Pattern`() {
        val testData = "kotlin"

        val expectedStringFromStateA = "StateA - (kotlin)"
        val expectedStringFromStateB = "StateB - (kotlin)"

        val context = KtStateContext(testData, KtStateA)
        assertEquals(expectedStringFromStateA, context.request())
        assertEquals(expectedStringFromStateB, context.request())
        assertEquals(expectedStringFromStateA, context.request())
        assertEquals(expectedStringFromStateB, context.request())
    }
}