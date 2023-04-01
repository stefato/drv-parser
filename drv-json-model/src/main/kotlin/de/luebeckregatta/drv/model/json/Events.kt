package de.luebeckregatta.drv.model.json

import com.fasterxml.jackson.annotation.JsonProperty

data class Events(
    @JsonProperty("_metadata")
    val metadata: Metadata,

    val regatta: Regatta,
    val events: List<Event>
)

