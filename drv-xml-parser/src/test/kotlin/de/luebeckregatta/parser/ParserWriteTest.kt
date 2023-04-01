package de.luebeckregatta.parser

import de.luebeckregatta.parser.testdata.MeldungenTestData
import de.luebeckregatta.testutils.TestUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class ParserWriteTest {

    @Test
    fun `should write Meldungen in expected format`() {
        val actualMeldungenXmlString = DrvXmlParser.writeMeldungenAsXmlString(MeldungenTestData.TEST_REGATTA_MELDUNGEN)

        val expectedMeldungenXmlString = TestUtils.readStringContentFromTestResourceFile("expected-meldungen.xml")
        assertThat(actualMeldungenXmlString).isEqualTo(expectedMeldungenXmlString)
    }

    @Test
    fun `should read written Meldungen`() {
        val meldungenXmlString = DrvXmlParser.writeMeldungenAsXmlString(MeldungenTestData.TEST_REGATTA_MELDUNGEN)

        val actualParsedMeldungen = DrvXmlParser.parseMeldungen(meldungenXmlString)

        val expectedParsedMeldungen = MeldungenTestData.TEST_REGATTA_MELDUNGEN
        assertThat(actualParsedMeldungen).usingRecursiveComparison()
            .isEqualTo(expectedParsedMeldungen)
    }


}
