package de.luebeckregatta.parser

import de.luebeckregatta.parser.testdata.AusschreibungTestData
import de.luebeckregatta.parser.testdata.MeldungenTestData
import de.luebeckregatta.parser.testdata.VereinTestData
import de.luebeckregatta.testutils.TestUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class ParserReadTest {

    companion object {
        @JvmStatic
        fun getTestParameters(): List<Arguments> {
            return listOf(
                arguments("meldungen-to-parse.xml", MeldungenTestData.TEST_REGATTA_MELDUNGEN, DrvXmlParser::parseMeldungen),
                arguments("vereine-to-parse.xml", VereinTestData.TEST_VEREINE, DrvXmlParser::parseVereine),
                arguments("ausschreibung-to-parse.xml", AusschreibungTestData.TEST_AUSSCHREIBUNG, DrvXmlParser::parseAusschreibung),
                arguments("vereine-with-date-time-from-portal.xml", VereinTestData.TEST_VEREINE, DrvXmlParser::parseVereine)
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
}
