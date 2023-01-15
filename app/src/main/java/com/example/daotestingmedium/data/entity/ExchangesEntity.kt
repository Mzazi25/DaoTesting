package com.example.daotestingmedium.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.daotestingmedium.data.entity.ExchangesEntity.Companion.COIN_ENTITY_ID


@Entity(
    tableName = ExchangesEntity.TABLE,
    foreignKeys = [
        ForeignKey(
            entity = CoinEntity::class,
            parentColumns = ["_id"],
            childColumns = [COIN_ENTITY_ID],
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class ExchangesEntity(
    @ColumnInfo(name = IS_ACTIVE)
    var active: Boolean,
    @ColumnInfo(name = COIN_ENTITY_ID)
    var coinEntityId: Int,
    @ColumnInfo(name = ADJUSTED_RANK)
    var adjustedRank: Int,
    @ColumnInfo(name = API_STATUS)
    var apiStatus: Boolean,
    @ColumnInfo(name = CURRENCIES)
    var currencies: Int,
    @ColumnInfo(name = DESCRIPTION)
    var description: String,
    @ColumnInfo(name = LAST_UPDATED)
    var lastUpdated: String,
    @ColumnInfo(name = MARKETS)
    var markets: Int,
    @ColumnInfo(name = MARKETS_DATA_FETCHED)
    var marketsDataFetched: Boolean,
    @ColumnInfo(name = MESSAGE)
    var message: String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = REPORTED_RANK)
    var reportedRank: Int,
    @ColumnInfo(name = WEBSITE_STATUS)
    var websiteStatus: Boolean
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Long = 0

    companion object {
        const val TABLE = "exchanges_entity_table"

        const val ID = "_id"
        const val COIN_ENTITY_ID = "coin_entity_id"
        const val IS_ACTIVE = "is_active"
        const val ADJUSTED_RANK = "adjusted_rank"
        const val API_STATUS = "api_status"
        const val CURRENCIES = "currencies"
        const val DESCRIPTION = "description"
        const val MARKETS = "markets"
        const val LAST_UPDATED = "last_updated"
        const val MARKETS_DATA_FETCHED = "markets_data_fetched"
        const val MESSAGE = "message"
        const val NAME = "name"
        const val REPORTED_RANK = "reported_rank"
        const val WEBSITE_STATUS = "website_status"

    }
}