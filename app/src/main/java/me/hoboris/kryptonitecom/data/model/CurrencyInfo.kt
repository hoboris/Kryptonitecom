package me.hoboris.kryptonitecom.data.model

import java.io.Serializable

data class CurrencyInfo(
    val id: String,
    val name: String,
    val symbol: String
): Serializable