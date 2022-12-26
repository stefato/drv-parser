package de.luebeckregatta.parser.testdata

import de.rudern.schemas.vereinsliste._2008.TVereine
import java.math.BigInteger
import java.time.OffsetDateTime
import java.time.ZoneOffset

object VereinTestData {

    val TEST_VEREIN_1 = de.rudern.schemas.vereinsliste._2008.TVerein().apply {
        ort = "testVereinsOrt1"
        name = "testVereinsName1"
        kurzform = "testVereinsKurzform1"
        lettern = "testVereinsLettern1"
        id = BigInteger.valueOf(10001)
    }

    val TEST_VEREIN_2 = de.rudern.schemas.vereinsliste._2008.TVerein().apply {
        ort = "testVereinsOrt2"
        name = "testVereinsName2"
        kurzform = "testVereinsKurzform2"
        lettern = "testVereinsLettern2"
        id = BigInteger.valueOf(11000)
    }

    val TEST_VEREINE = TVereine().apply {
        verein = listOf(TEST_VEREIN_1, TEST_VEREIN_2)
        erstellt = OffsetDateTime.of(2022, 12, 23, 20, 36, 49, 0, ZoneOffset.of("+1"))
    }
}