package behavioral

import org.junit.Assert.assertEquals
import org.junit.Test


class TemplateMethodTest {

    @Test fun `Standard Template Method Pattern`() {

        val expectedStringFromAlgorithm1 = "A1S1A1S2"
        val expectedStringFromAlgorithm2 = "A2S1A2S2"

        var algorithm : AbstractAlgorithm = Algorithm1()
        assertEquals(expectedStringFromAlgorithm1, algorithm.algorithm())

        algorithm = Algorithm2()
        assertEquals(expectedStringFromAlgorithm2, algorithm.algorithm())
    }
}