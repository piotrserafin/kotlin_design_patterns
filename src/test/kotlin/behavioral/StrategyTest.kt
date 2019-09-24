package behavioral

import org.junit.Assert.assertEquals
import org.junit.Test


class StrategyTest {

    @Test fun `Standard Strategy Pattern`() {
        val testData = "standard"

        val expectedStringFromStrategyA = "StrategyA - (standard)"
        val expectedStringFromStrategyB = "StrategyB - (standard)"

        val context = StdStrategyContext(testData, StdStrategyA())
        assertEquals(expectedStringFromStrategyA, context.request())

        context.strategy = StdStrategyB()
        assertEquals(expectedStringFromStrategyB, context.request())
    }

    @Test fun `Kotlin Strategy Pattern`() {
        val testData = "kotlin"

        val expectedStringFromStrategyA = "StrategyA - (kotlin)"
        val expectedStringFromStrategyB = "StrategyB - (kotlin)"

        val context = KtContext(testData, ktStrategyA)
        assertEquals(expectedStringFromStrategyA, context.request())

        context.ktStrategy = ktStrategyB
        assertEquals(expectedStringFromStrategyB, context.request())
    }
}