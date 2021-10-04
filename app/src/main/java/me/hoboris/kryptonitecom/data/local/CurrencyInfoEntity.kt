package me.hoboris.kryptonitecom.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.hoboris.kryptonitecom.data.model.CurrencyInfo

@Entity(tableName = RoomConstants.CURRENCY_TABLE_NAME)
data class CurrencyInfoEntity(
    @ColumnInfo(index = true)
    @PrimaryKey val id: String,
    @ColumnInfo(index = true)
    val name: String,
    val symbol: String
) {
    fun toCurrencyInfo() = CurrencyInfo(
        id,
        name,
        symbol
    )
}

fun CurrencyInfo.toCurrencyInfoEntity() = CurrencyInfoEntity(
    id,
    name,
    symbol
)