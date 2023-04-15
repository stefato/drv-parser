package de.luebeckregatta.parser.testdata

import de.rudern.schemas.service.meldungen._2010.*
import java.time.*

object MeldungenTestData {

    val TEST_ATHLET_1 = TAthlet().apply {
        name = "testAthletName1"
        vorname = "testAthletVorname1"
        jahrgang = 1921
        geschlecht = "m"
        id = "DE-11111-1"
        verein = 10001
    }

    val TEST_ATHLET_2 = TAthlet().apply {
        name = "testAthletName2"
        vorname = "testAthletVorname2"
        jahrgang = 1922
        geschlecht = "m"
        id = "DE-22222-2"
        verein = 11000
    }

    val TEST_ATHLET_3 = TAthlet().apply {
        name = "testAthletName3"
        vorname = "testAthletVorname3"
        jahrgang = 1921
        geschlecht = "m"
        id = "DE-33333-3"
        verein = 11000
    }

    val TEST_ATHLET_4 = TAthlet().apply {
        name = "testAthletName4"
        vorname = "testAthletVorname4"
        jahrgang = 1921
        geschlecht = "m"
        id = "DE-44444-4"
        verein = 10001
    }

    private val TEST_OBMANN_1 = TObmann().apply {
        id = "123"
        name = "testname1"
        email = "testmail1"
        phone = "testphone1"
    }

    private val TEST_OBMANN_2 = TObmann().apply {
        id = "456"
        name = "testname2"
        email = "testmail2"
        phone = "testphone2"
    }

    val TEST_BOOTS_POSITION_1 = TBootsPosition().apply {
        athlet = TEST_ATHLET_1
        nr = 1
        isSt = true
    }

    val TEST_BOOTS_POSITION_2 = TBootsPosition().apply {
        athlet = TEST_ATHLET_2
        nr = 2
        isSt = false
    }

    val TEST_BOOTS_POSITION_3 = TBootsPosition().apply {
        athlet = TEST_ATHLET_3
        nr = 1
        isSt = false
    }

    val TEST_BOOTS_POSITION_4 = TBootsPosition().apply {
        athlet = TEST_ATHLET_4
        nr = 2
        isSt = true
    }

    val TEST_MELDUNG_1 = TMeldung().apply {
        id = "1234"
        verein = 10001
        obmann = "123"
        mannschaft = listOf(TEST_BOOTS_POSITION_1, TEST_BOOTS_POSITION_2)
        titel = "testTitel1"
    }

    val TEST_MELDUNG_2 = TMeldung().apply {
        id = "6789"
        verein = 11000
        obmann = "456"
        mannschaft = listOf(TEST_BOOTS_POSITION_3, TEST_BOOTS_POSITION_4)
        titel = "testTitel2"
    }

    val TEST_MELDUNG_3 = TMeldung().apply {
        id = "2834"
        verein = 10001
        obmann = "456"
        mannschaft = listOf(TEST_BOOTS_POSITION_3)
        titel = "testTitel3"
    }

    val TEST_RENNEN_1 = TRennen().apply {
        nummer = "350"
        spezifikation = "Jung 2x+"
        meldung = listOf(TEST_MELDUNG_1, TEST_MELDUNG_2)
    }

    val TEST_RENNEN_2 = TRennen().apply {
        nummer = "351"
        spezifikation = "Mäd 2x+"
        meldung = listOf(TEST_MELDUNG_3)
    }

    val TEST_VEREIN_1 = TVerein().apply {
        ort = "testVereinsOrt1"
        name = "testVereinsName1"
        kurzform = "testVereinsKurzform1"
        lettern = "testVereinsLettern1"
        id = 10001
    }

    val TEST_VEREIN_2 = TVerein().apply {
        ort = "testVereinsOrt2"
        name = "testVereinsName2"
        kurzform = "testVereinsKurzform2"
        lettern = "testVereinsLettern2"
        id = 11000
    }

    val TEST_REGATTA_MELDUNGEN = RegattaMeldungen().apply {
        obleute = listOf(TEST_OBMANN_1, TEST_OBMANN_2)
        meldungen = listOf(TEST_RENNEN_1, TEST_RENNEN_2)
        vereine = listOf(TEST_VEREIN_1, TEST_VEREIN_2)
        stand =  OffsetDateTime.of(2022, 12, 1, 11, 11, 11,0, ZoneOffset.of("+1"))
    }
}