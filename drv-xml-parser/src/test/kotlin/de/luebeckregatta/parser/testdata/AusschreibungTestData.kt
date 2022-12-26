package de.luebeckregatta.parser.testdata

import de.rudern.schemas.service.ausschreibung._2010.*
import de.rudern.schemas.service.ausschreibung._2010.TAngaben.Bestimmung
import java.time.*


object AusschreibungTestData {

    val TEST_PARAMETERS = TRennen.Parameters().apply {
        param = TRennen.Parameters.Param().apply {
            name = "testParam"
            value = "testValue"
        }
    }

    val TEST_RENNEN_1 = TRennen().apply {
        nummer = "1"
        spezifikation = "testSpezifikation1"
        zusatz = "testZusatz1"
        parameters = TEST_PARAMETERS

        datum = LocalDate.of(2022, 1, 1)
    }

    val TEST_RENNEN_2 = TRennen().apply {
        nummer = "2"
        spezifikation = "testSpezifikation2"
        zusatz = "testZusatz2"
        parameters = TEST_PARAMETERS
        datum = LocalDate.of(2022, 12, 31)
    }

    val TEST_ANGABEN = TAngaben().apply {
        titel = "testRegattaTitel"
        subTitel = "testRegattaSubTitel"
        ort = "testRegattaOrt"
        veranstalter = TVeranstalter().apply {
            value = "testVeranstalterValue"
            id = "testVeranstalterId"
        }

        startDatum = LocalDate.of(2025, 1, 1)
        endDatum = LocalDate.of(2025, 1, 10)
        meldeschluss = OffsetDateTime.of(2024, 12, 1, 10, 0, 0,0, ZoneOffset.of("+1"))

        homepage = "testHomepage"
        email = "testEmail"

        bestimmungen = listOf(
            Bestimmung().apply {
                nr = 1
                inhalt = "application/xhtml+xml"
            }, Bestimmung().apply {
                nr = 2
                inhalt = "text/plain"
            })
    }

    val TEST_REGATTA = TRegatta().apply {
        angaben = TEST_ANGABEN
        rennfolge = listOf(TEST_RENNEN_1, TEST_RENNEN_2)
        stand =  OffsetDateTime.of(2024, 12, 15, 15, 0, 33,0, ZoneOffset.of("+1"))
    }

    val TEST_AUSSCHREIBUNG = TAusschreibung().apply {
        regatta = listOf(TEST_REGATTA)
    }
}