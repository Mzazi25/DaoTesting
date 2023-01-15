package com.example.daotestingmedium.resource

import com.example.daotestingmedium.data.entity.CoinEntity
import com.example.daotestingmedium.data.entity.ExchangesEntity
import com.example.daotestingmedium.data.entity.TickersEntity

object FakeFileGenerator {
    val fakeCoins = CoinEntity(
        isActive = false,
        isNew = true,
        name = "coins",
        rank = 1,
        symbol = "symbol",
        type = "type"
    )

    val fakeExchanges = ExchangesEntity(
        active = true,
        coinEntityId = 1,
        adjustedRank = 1,
        apiStatus = false,
        currencies = 4,
        description = "description",
        lastUpdated = "last_updated",
        markets = 4,
        marketsDataFetched = false,
        message = "new",
        name = "name",
        reportedRank = 6,
        websiteStatus = true
    )

    val fakeTickers = TickersEntity(
        betaValue = 4.44,
        exchangesEntityId = 5,
        circulatingSupply = 8,
        firstDataAt = "first_data",
        lastUpdated = "last_updated",
        maxSupply = 8,
        name = "name",
        rank = 9,
        symbol = "symbol",
        totalSupply = 90
    )
}