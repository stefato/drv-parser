package de.luebeckregatta.drv.model.json

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class Event(
    val id: String,
    val number: String,
    val code: String,
    val name: String,
    val addition: String? = null,
    val sex: String? = null,
    val weighed: Boolean? = null,
    val days: List<LocalDate>,
    val remarks: String? = null,
    val category: BoatType? = null,
    val boattype: BoatType? = null,
    val cost: Cost? = null,

    @JsonProperty("parent_event_id")
    val parentEventId: String? = null,

    @JsonProperty("number_addition")
    val numberAddition: String? = null
)