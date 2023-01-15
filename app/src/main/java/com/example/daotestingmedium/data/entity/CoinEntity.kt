package com.example.daotestingmedium.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CoinEntity.TABLE)
data class CoinEntity(
    @ColumnInfo(name = IS_ACTIVE)
    var isActive: Boolean,
    @ColumnInfo(name = IS_NEW)
    var isNew: Boolean,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = RANK)
    var rank: Int,
    @ColumnInfo(name = SYMBOL)
    var symbol: String,
    @ColumnInfo(name = TYPE)
    var type: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Long = 0

    companion object {
        const val TABLE = "coin_entity_table"

        const val ID = "_id"
        const val IS_ACTIVE = "is_active"
        const val IS_NEW = "is_new"
        const val NAME = "name"
        const val RANK = "rank"
        const val SYMBOL = "symbol"
        const val TYPE = "type"

    }
}