package me.hoboris.kryptonitecom.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyInfoDao {

    @Query("""SELECT * FROM ${RoomConstants.CURRENCY_TABLE_NAME}  ORDER BY
            CASE WHEN :isAsc = 1 THEN name END ASC,
            CASE WHEN :isAsc = 0 THEN name END DESC""")
    fun getAllCurrencyInfo(isAsc: Boolean): Flow<List<CurrencyInfoEntity>>
}
