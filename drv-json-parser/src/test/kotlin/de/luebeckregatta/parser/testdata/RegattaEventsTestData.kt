package de.luebeckregatta.parser.testdata

import de.luebeckregatta.drv.model.json.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit


object RegattaEventsTestData {

    val TEST_REGATTA = Regatta(
        "01871586-d9c4-7341-a892-6dbc8faa72ae",
        "93.LübeckRegatta",
        "Lübeck",
        "www.luebeckregatta.de",
        "de",
        listOf(
            LocalDate.of(2023, Month.APRIL, 29),
            LocalDate.of(2023, Month.APRIL, 30)
        )
    )

    val TEST_METADATA = Metadata(
        LocalDateTime.of(2023, Month.MARCH, 28, 17, 31, 54)
            .plus(293, ChronoUnit.MILLIS)
            .plus(354, ChronoUnit.MICROS)
            .toInstant(ZoneOffset.UTC)
    )

    val TEST_EVENT_1 = Event(
        "01871586-daf2-71ff-a129-49c7089c2b37",
        "001",
        "SM 4- A",
        "Männer-Vierer ohne St. A",
        "(WP)*",
        "M",
        false,
        listOf(LocalDate.of(2023, Month.APRIL, 29)),
        null,
        BoatType("0186744a-be10-73f6-a6d3-f6764796053d", "A", "Senior A"),
        BoatType("0186744a-6aee-72f1-b997-5b43647e9ada", "4-", "Vierer ohne St."),
        Cost("0187273a-ce47-7333-805e-4ba38cb007f3", "Vierer", "EUR", 30.0),
        "333",
        "444"
    )

    val TEST_EVENT_2 = Event(
        "01871586-db00-7126-8939-1211d0363eb0",
        "002",
        "JM 1x A Lgr. III",
        "Junioren-Einer A Lgr. III",
        null,
        "M",
        true,
        listOf(LocalDate.of(2023, Month.APRIL, 29), LocalDate.of(2023, Month.APRIL, 30)),
        "testRemarks",
        BoatType("0186744a-bdad-7003-9f5e-f9f947c149c9", "A Lgr. III", "Junior A Leistungsgruppe III"),
        BoatType("0186744a-6aa9-71d6-990c-1a071de5a488", "1x", "Einer"),
        Cost("0187273a-1906-7013-8984-7a8416d80fcd", "Einer", "EUR", 18.0)
    )

    val TEST_EVENTS = Events(
        TEST_METADATA,
        TEST_REGATTA,
        listOf(TEST_EVENT_1, TEST_EVENT_2)
    )
}