package me.hoboris.kryptonitecom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CurrencyInfoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyInfoDao(): CurrencyInfoDao
}