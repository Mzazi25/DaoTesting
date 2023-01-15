package com.example.daotestingmedium.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daotestingmedium.data.entity.CoinEntity
import com.example.daotestingmedium.data.entity.ExchangesEntity
import com.example.daotestingmedium.data.entity.TickersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TestingDao {

    @Query("SELECT * FROM coin_entity_table")
    fun getCoinList(): Flow<List<CoinEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coinEntity: CoinEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchanges(exchangesEntity: ExchangesEntity): Long

    @Query("SELECT * FROM exchanges_entity_table WHERE _id = :id")
    suspend fun getExchangesById(id: Long): ExchangesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTickers(tickersEntity: TickersEntity): Long

    @Query("SELECT * FROM tickers_entity_table WHERE _id = :id")
    suspend fun getTickersById(id: Long): TickersEntity
}