package com.example.daotestingmedium.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.daotestingmedium.data.entity.TickersEntity.Companion.EXCHANGES_ENTITY_ID

@Entity(
    tableName = TickersEntity.TABLE,
    foreignKeys = [
        ForeignKey(
            entity = ExchangesEntity::class,
            parentColumns = ["_id"],
            childColumns = [EXCHANGES_ENTITY_ID],
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class TickersEntity(
    @ColumnInfo(name = BETA_VALUE)
    var betaValue: Double,
    @ColumnInfo(name = EXCHANGES_ENTITY_ID)
    var exchangesEntityId: Int,
    @ColumnInfo(name = CIRCULATING_SUPPLY)
    var circulatingSupply: Int,
    @ColumnInfo(name = FIRST_DATA_AT)
    var firstDataAt: String,
    @ColumnInfo(name = LAST_UPDATED)
    var lastUpdated: String,
    @ColumnInfo(name = MAX_SUPPLY)
    var maxSupply: Int,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = RANK)
    var rank: Int,
    @ColumnInfo(name = SYMBOL)
    var symbol: String,
    @ColumnInfo(name = TOTAL_SUPPLY)
    var totalSupply: Int
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Long = 0

    companion object {
        const val TABLE = "tickers_entity_table"

        const val ID = "_id"
        const val EXCHANGES_ENTITY_ID = "exchanges_entity_id"
        const val BETA_VALUE = "beta_value"
        const val CIRCULATING_SUPPLY = "circulating_supply"
        const val FIRST_DATA_AT = "first_data_at"
        const val LAST_UPDATED = "last_updated"
        const val MAX_SUPPLY = "max_supply"
        const val NAME = "name"
        const val SYMBOL = "symbol"
        const val RANK = "rank"
        const val TOTAL_SUPPLY = "total_supply"

    }
}