package de.luebeckregatta.parser

import de.luebeckregatta.parser.testdata.RegattaEventsTestData
import de.luebeckregatta.testutils.TestUtils
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class ParserReadTest {

    @Test
    fun shouldParseRegattaEvents() {
        // GIVEN
        val jsonString = TestUtils.readStringContentFromTestResourceFile("regatta-events-to-parse.json")

        // WHEN
        val actualParsedEvents = DrvJsonParser.parseEvents(jsonString)

        // THEN
        val softly = SoftAssertions()

        softly.assertThat(actualParsedEvents).usingRecursiveComparison().ignoringFields("events")
            .isEqualTo(RegattaEventsTestData.TEST_EVENTS)

        softly.assertThat(actualParsedEvents.events)
            .hasSize(250)

        val actualFirstEvent = actualParsedEvents.events[0]
        val actualSecondEvent = actualParsedEvents.events[1]

        softly.assertThat(actualFirstEvent).usingRecursiveComparison()
            .isEqualTo(RegattaEventsTestData.TEST_EVENT_1)

        softly.assertThat(actualSecondEvent).usingRecursiveComparison()
            .isEqualTo(RegattaEventsTestData.TEST_EVENT_2)

        softly.assertAll()
    }
}