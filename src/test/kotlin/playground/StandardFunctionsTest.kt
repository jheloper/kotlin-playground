package playground

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * @author joonghyeon.kim
 */

class StandardFunctionsTest {
    @Test
    fun testCreateFileByApplyFunction() {
        val file = createFileByApplyFunction()
        assertTrue(file.canRead())
        assertTrue(file.canWrite())
        assertFalse(file.canExecute())
    }

    @Test
    fun testGetFirstItemSquaredByLetFunction() {
        val firstItemSquared = getFirstItemSquaredByLetFunction()
        assertEquals(9, firstItemSquared)
    }

    @Test
    fun testFormatGreeting() {
        println(formatGreeting("Nathan"))
    }

    @Test
    fun testIsContainToFile() {
        assertFalse(isContainToFile("Dragon's Breath"))
    }

    @Test
    fun testNameIsLong() {
        assertFalse("Madrigal".run(::nameIsLong))
        assertTrue("Polarcubis, Supreme Master of NyetHack".run(::nameIsLong))
    }

    @Test
    fun testNameIsLongAndPlayerCreateMessage() {
        "Polarcubis, Supreme Master of NyetHack"
            .run(::nameIsLong)
            .run(::playerCreateMessage)
            .run(::println)
    }
}