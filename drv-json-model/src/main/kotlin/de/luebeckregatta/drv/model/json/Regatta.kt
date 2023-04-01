package de.luebeckregatta.drv.model.json

import java.time.LocalDate

data class Regatta(
    val id: String,
    val name: String,
    val city: String,
    val website: String,
    val language: String,
    val days: List<LocalDate>
)