package com.example.daotestingmedium.data.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.daotestingmedium.data.db.TestingDatabase
import com.example.daotestingmedium.resource.FakeFileGenerator
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TestingDaoTest {

    private lateinit var testingDao: TestingDao
    private lateinit var database: TestingDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context, TestingDatabase::class.java
        ).build()
        testingDao = database.testingDao()
    }

    @Test
    @Throws(Exception::class)
    fun `insert coins to app database, assert valid coins `() = runBlocking {
        testingDao.insertCoin(FakeFileGenerator.fakeCoins)
        val result = testingDao.getCoinList().first().first()
        Assert.assertEquals(result, FakeFileGenerator.fakeCoins)
    }

    @Test
    @Throws(Exception::class)
    fun `insert exchanges to app database, assert valid Exchanges, querying description`() = runBlocking {
        val coinId = testingDao.insertCoin(FakeFileGenerator.fakeCoins)
        FakeFileGenerator.fakeCoins.id = coinId
        //Assert fakeCoinId has been changed
        Assert.assertEquals(coinId, FakeFileGenerator.fakeCoins.id)
        val newExchanges = FakeFileGenerator.fakeExchanges.copy(coinEntityId = coinId)

        val newExchangesId = testingDao.insertExchanges(newExchanges)
        val getExchanges = testingDao.getExchangesById(newExchangesId)

        Assert.assertEquals(getExchanges.description, FakeFileGenerator.fakeExchanges.description)
    }

    @Test
    @Throws(Exception::class)
    fun `insert tickers to app database, assert valid Tickers, querying name`() = runBlocking {
        //Get Coin Id
        val coinId = testingDao.insertCoin(FakeFileGenerator.fakeCoins)
        FakeFileGenerator.fakeCoins.id = coinId
        val newExchanges = FakeFileGenerator.fakeExchanges.copy(coinEntityId = coinId)
        //Get Exchanges Id
        val newExchangesId = testingDao.insertExchanges(newExchanges)
        newExchanges.id =newExchangesId
        //Generate new Ticker with the new exchange ID
        val newTickers = FakeFileGenerator.fakeTickers.copy(exchangesEntityId = newExchangesId)
        val id = testingDao.insertTickers(newTickers)
        val getTickersById = testingDao.getTickersById(id)

        Assert.assertEquals(getTickersById.name, FakeFileGenerator.fakeTickers.name)
    }

    @After
    @Throws(IOException::class)
    fun tearDown(){
        database.close()
    }
}