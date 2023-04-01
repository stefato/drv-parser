package de.luebeckregatta.testutils

import java.io.File

object TestUtils {
    fun readStringContentFromTestResourceFile(testResourceFileName: String): String {
        val classLoader = javaClass.classLoader
        val resource = classLoader.getResource(testResourceFileName)
        val file = File(resource?.file ?: throw RuntimeException())
        return file.bufferedReader().use {
            it.readText()
        }
    }
}