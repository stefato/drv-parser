package de.luebeckregatta.parser

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import de.rudern.schemas.service.ausschreibung._2010.TAusschreibung
import de.rudern.schemas.service.meldungen._2010.RegattaMeldungen
import de.rudern.schemas.vereinsliste._2008.TVereine

object DrvXmlParser {

    private val xmlMapper = XmlMapper.builder()
        .defaultUseWrapper(false)
        .configure(SerializationFeature.INDENT_OUTPUT, true)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .build()
        .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
        .registerModule(JavaTimeModule())
        .registerModule(JaxbAnnotationModule())
        .registerModule(KotlinModule(nullToEmptyCollection = true, nullToEmptyMap = true))

    fun parseMeldungen(xmlString: String): RegattaMeldungen {
        return xmlMapper.readValue(xmlString, RegattaMeldungen::class.java)
    }

    fun writeMeldungenAsXmlString(meldungen: RegattaMeldungen): String {
        return xmlMapper.writeValueAsString(meldungen)
    }

    fun parseVereine(xmlString: String): TVereine {
        return xmlMapper.readValue(xmlString, TVereine::class.java)
    }

    fun parseAusschreibung(xmlString: String): TAusschreibung {
        return xmlMapper.readValue(xmlString, TAusschreibung::class.java)
    }
}