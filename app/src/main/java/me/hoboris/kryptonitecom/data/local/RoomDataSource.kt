package me.hoboris.kryptonitecom.data.local

import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.hoboris.kryptonitecom.App
import me.hoboris.kryptonitecom.data.model.CurrencyInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomDataSource @Inject constructor() {

    private val db: AppDatabase by lazy {
        Room
            .databaseBuilder(
                App.applicationContext,
                AppDatabase::class.java,
                RoomConstants.DATABASE_NAME
            )
            .createFromAsset(RoomConstants.DATABASE_NAME)
            .build()
    }

    fun getAllCurrencyInfo(sortMode: SortMode): Flow<List<CurrencyInfo>> {
        return db.currencyInfoDao().getAllCurrencyInfo(sortMode == SortMode.ASCENDANT).map { currencyInfoEntities ->
            currencyInfoEntities
                .filter { currencyInfoEntity ->
                    currencyInfoEntity.id.isNotEmpty() &&
                            currencyInfoEntity.name.isNotEmpty() &&
                            currencyInfoEntity.symbol.isNotEmpty()
                }
                .map { currencyInfoEntity ->
                    currencyInfoEntity.toCurrencyInfo()
                }
        }
    }
}