package de.luebeckregatta.parser

import com.fasterxml.jackson.databind.JsonMappingException
import de.luebeckregatta.parser.testdata.AusschreibungTestData
import de.luebeckregatta.parser.testdata.MeldungenTestData
import de.luebeckregatta.parser.testdata.VereinTestData
import de.luebeckregatta.parser.testutils.TestUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ParserReadTest {

    companion object {
        @JvmStatic
        fun getTestParameters(): List<Arguments> {
            return listOf(
                Arguments.of("meldungen-to-parse.xml", MeldungenTestData.TEST_REGATTA_MELDUNGEN, DrvXmlParser::parseMeldungen),
                Arguments.of("vereine-to-parse.xml", VereinTestData.TEST_VEREINE, DrvXmlParser::parseVereine),
                Arguments.of("ausschreibung-to-parse.xml", AusschreibungTestData.TEST_AUSSCHREIBUNG, DrvXmlParser::parseAusschreibung)
            )
        }
    }

    @ParameterizedTest(name = "{0} should be parsed to the expected object")
    @MethodSource("getTestParameters")
    fun `should parse Xml to the expected object`(xmlFilenameToParse: String, expectedParsedObject: Any, parseFunction: (String) -> Any) {
        val xmlString = TestUtils.readStringContentFromTestResourceFile(xmlFilenameToParse)

        val actualParsedObject = parseFunction(xmlString)

        assertThat(actualParsedObject).usingRecursiveComparison()
            .isEqualTo(expectedParsedObject)
    }

    @Test
    fun `test parse Vereine xml downloaded from drv-portal`() {
        val xmlString = TestUtils.readStringContentFromTestResourceFile("vereine-2023-01-07.xml")

        assertThrows<JsonMappingException> { DrvXmlParser.parseVereine(xmlString); }

    }
}
