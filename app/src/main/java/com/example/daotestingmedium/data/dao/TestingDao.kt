package com.example.daotestingmedium.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daotestingmedium.data.entity.CoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TestingDao {

    @Query("SELECT * FROM coin_entity_table")
    fun getAllPlanterInfo(): Flow<List<CoinEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanterInfo(coinEntity: CoinEntity): Long

}