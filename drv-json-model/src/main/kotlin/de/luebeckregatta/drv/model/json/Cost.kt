package de.luebeckregatta.drv.model.json

data class Cost(
    val id: String,
    val name: String,
    val currency: String,
    val amount: Double
)