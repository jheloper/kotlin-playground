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
        createNewFile()
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

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. your table is already ready."
    } ?: "Welcome, I will ready table soon."
}

fun isContainToFile(sentence: String): Boolean {
    val menuFile = File("menu-file.txt")
    val servesDragonsBreath = menuFile.run {
        readText().contains(sentence)
    }

    return servesDragonsBreath
}

fun nameIsLong(name: String) = name.length >= 20

fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too long. Please choose another name."
    } else {
        "Welcome, adventurer."
    }
}

fun getFileContents(): List<String> {
    var fileContents: List<String>
    File("file.txt")
        .also {
            println(it.name)
        }.also {
            fileContents = it.readLines()
        }
    return fileContents
}