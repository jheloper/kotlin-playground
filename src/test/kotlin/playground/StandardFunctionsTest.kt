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
}