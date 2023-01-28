package de.luebeckregatta.model.adapter;

import io.github.threetenjaxb.core.TemporalAccessorXmlAdapter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DrvOffsetDateTimeXmlAdapter extends TemporalAccessorXmlAdapter<OffsetDateTime> {

    private static final DateTimeFormatter DRV_OFFSET_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            .optionalStart().appendOffset("+HHMM", "+0000").optionalEnd()
            .optionalStart().appendOffsetId().optionalEnd()
            .toFormatter();

    public DrvOffsetDateTimeXmlAdapter() {
        super(DRV_OFFSET_DATE_TIME_FORMATTER, OffsetDateTime::from);
    }
}
