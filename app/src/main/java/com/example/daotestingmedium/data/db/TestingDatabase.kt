package com.example.daotestingmedium.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daotestingmedium.data.dao.TestingDao
import com.example.daotestingmedium.data.entity.CoinEntity
import com.example.daotestingmedium.data.entity.ExchangesEntity
import com.example.daotestingmedium.data.entity.TickersEntity

@Database(
    entities = [CoinEntity::class, ExchangesEntity::class, TickersEntity::class],
    version = 1,
    exportSchema = false)
abstract class TestingDatabase: RoomDatabase(){
    abstract fun testingDao():TestingDao
}