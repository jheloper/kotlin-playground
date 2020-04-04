package playground

import java.io.File

/**
 * @author joonghyeon.kim
 */

fun createFileByApplyFunction(): File {
    // val menuFile = File("menu-file.txt")
    // menuFile.setReadable(true)
    // menuFile.setWritable(true)
    // menuFile.setExecutable(false)

    val menuFile = File("menu-file.txt").apply {
        mkdirs()
        setReadable(true, false)
        setWritable(true, false)
        setExecutable(false, false)
    }

    return menuFile
}

fun getFirstItemSquaredByLetFunction(): Int {
    // val firstElement = listOf(3, 4, 5).first()
    // val firstItemSquared = firstElement * firstElement

    val firstItemSquared = listOf(3, 4, 5).first().let {
        it * it
    }

    return firstItemSquared
}